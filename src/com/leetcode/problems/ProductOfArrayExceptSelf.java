package com.leetcode.problems;

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		int[] dp = new int[nums.length];
		int prod = nums[0];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = prod;
			prod = prod * nums[i];
		}
		prod = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			dp[i] *= prod;
			prod = prod * nums[i];
		}
		return dp;
	}

}
