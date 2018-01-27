package com.leetcode.problems;

import java.util.Arrays;

public class ThreeSumSmaller {
	
	public int threeSumSmaller(int[] nums, int target) {
        int cnt = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0;i < n - 2;i++) {
            int l = i + 1;
            int h = n - 1;
            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (sum >= target ) {
                    h--;
                } else {
                    cnt += h - l;
                    l++;
                }
            }
        }
        return cnt;
    }

}
