package com.leetcode.problems;

public class LongestSubstringwithAtMostKDistinctCharacters {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[255];
        int maxLen = 0;
        int start = 0;
        int noOfDistinctCharacters = 0;
        for (int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if (map[c] == 0) {
                noOfDistinctCharacters++;
                map[c] = 1;
                if (noOfDistinctCharacters > k) {
                    while (noOfDistinctCharacters > k && map[s.charAt(start)] > 0) {
                        map[s.charAt(start)]--;
                        if (map[s.charAt(start++)] == 0) noOfDistinctCharacters--;
                    }
                } else maxLen = Math.max(maxLen, i - start + 1);
            } else {
                map[c]++;
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        return maxLen;
    }
	
	

}
