package com.leetcode.problems;

public class SearchInsertPosition {
	
	 public int searchInsert(int[] nums, int target) {
	        int n = nums.length;
	        int l = 0;
	        int h = n - 1;
	        int m = 0;
	        while (l <= h) {
	            m = l + (h - l) / 2;
	            if (nums[m] == target) {
	                return m;
	            } else if (nums[m] < target) {
	                l = m + 1;
	            } else {
	                h = m - 1;
	            }
	        }
	        return l;
	    }

}
