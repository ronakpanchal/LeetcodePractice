package com.leetcode.problems;

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		int minLen = Integer.MAX_VALUE;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum >= s) {
				while (j < nums.length && sum - nums[j] >= s) sum -= nums[j++];
				minLen = Math.min(minLen, i - j + 1);

			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

}
