package com.leetcode.problems;

public class SubarrayProductLessThanK {

	public static void main(String[] args) {
		SubarrayProductLessThanK obj = new SubarrayProductLessThanK();
		obj.numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 0);
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int cnt = 0;
		int start = 0;
		int prod = 1;
		for (int i = 0; i < nums.length; i++) {
			prod = prod * nums[i];
			while (prod >= k && start < nums.length) prod /= nums[start++];
			if (i >= start) cnt += (i - start + 1);
		}
		return cnt;
	}

}
