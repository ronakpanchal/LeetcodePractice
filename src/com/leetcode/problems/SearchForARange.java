package com.leetcode.problems;

public class SearchForARange {
	
	public int[] searchRange(int[] nums, int target) {
		int[] ans = new int[2];
		int i1 = -1, i2 = -1;
		int l = 0, h = nums.length - 1, m = 0;
		while (l <= h) {
		    m = l + (h - l) / 2;
		    if (nums[m] >= target) h = m - 1;
		    else l = m + 1;
		    if (nums[m] == target) i1 = m;
		}
		ans[0] = i1;
		l = 0; 
		h = nums.length - 1; 
		m = 0;
		while (l <= h) {
		    m = l + (h - l) / 2;
		    if (nums[m] <= target) l = m + 1;
		    else h = m - 1;
		    if (nums[m] == target) i2 = m;
		}
		ans[1] = i2;
		return ans;
	 }

}
