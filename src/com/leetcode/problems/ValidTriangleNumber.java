package com.leetcode.problems;

import java.util.Arrays;

public class ValidTriangleNumber {
	
	public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        int n = nums.length;
        for (int i = n - 1;i >= 2;i--) {
            int l = 0;
            int h = i - 1;
            while (l < h) {
                int sum = nums[l] + nums[h];
                if (sum > nums[i]) {
                    cnt += h - l;
                    h--;
                } else {
                    l++;
                }
            }
        }
        return cnt;
    }

}
