package com.leetcode.problems;

public class FindPeakElement {
	
	public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int m = 0;
        while (l < h) {
            m = l + (h - l) / 2;
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }

}
