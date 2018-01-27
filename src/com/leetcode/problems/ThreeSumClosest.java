package com.leetcode.problems;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0;i < n - 2;i++) {
            int l = i + 1;
            int h = n - 1;
            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    result = sum;
                } else if (sum > target) {
                    h--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }

}
