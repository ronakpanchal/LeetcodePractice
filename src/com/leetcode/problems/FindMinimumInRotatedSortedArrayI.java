package com.leetcode.problems;

public class FindMinimumInRotatedSortedArrayI {
	
	public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int m = 0;
        while (l <= h) {
            m = l + (h - l) / 2;
            if (nums[l] <= nums[h]) return nums[l];
            else if (nums[m] > nums[h]) l = m + 1;
            else  h = m;
        }
        return nums[l];
    }

}
