package com.leetcode.problems;

public class LongestSubstringWithoutRepeatingCharcters {
	
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] map = new int[256];
        int j = 0;
        int max = 0;
        for (int i = 0;i < s.length();i++) {
            if (map[s.charAt(i)] == 0) {
                map[s.charAt(i)] = 1;
                max = Math.max(max, i - j + 1);
            } else {
                while (s.charAt(i) != s.charAt(j) && j < i) {
                    map[s.charAt(j)] = 0;
                    j++;
                }
                j++;
            }
        }
        return max;
    }

}
