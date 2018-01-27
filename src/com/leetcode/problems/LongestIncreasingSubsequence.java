package com.leetcode.problems;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		if (nums.length == 0) return 0;
		int max = 1;
		Arrays.fill(dp, 1);
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
