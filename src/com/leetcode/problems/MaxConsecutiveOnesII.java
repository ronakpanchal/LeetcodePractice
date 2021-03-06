package com.leetcode.problems;

public class MaxConsecutiveOnesII {

	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int curr = 0;
		int lastZero = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				lastZero = i;
				if (lastZero == -1) curr++;
				else curr = i - lastZero;
			} else 
				curr++;
			max = Math.max(max, curr);
		}
		return max;
	}

}
