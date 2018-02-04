package com.leetcode.problems;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		int[] smap = new int[128];
		int[] tmap = new int[128];
		for (int i = 0; i < t.length(); i++) tmap[t.charAt(i)]++;
		int minLen = Integer.MAX_VALUE;
		String result = "";
		int noOfMatch = 0;
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			smap[c]++;
			if (smap[c] > 0 && smap[c] <= tmap[c]) noOfMatch++;
			if (noOfMatch == t.length()) {
				while (j < i && smap[s.charAt(j)] > tmap[s.charAt(j)]) smap[s.charAt(j++)]--;
				if (i - j + 1 < minLen) {
					minLen = i - j + 1;
					result = s.substring(j, j + minLen);
				}
			}
		}
		return result;
	}

}
