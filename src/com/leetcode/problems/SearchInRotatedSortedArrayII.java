package com.leetcode.problems;

public class SearchInRotatedSortedArrayII {
	
	public boolean search(int[] nums, int target) {
        int l = 0, h = nums.length - 1, m = 0;
        while (l <= h) {
            m = l + (h - l) / 2;
            if (nums[m] == target) return true;
            else if (nums[m] < nums[h]) {
                if (nums[m] < target && target <= nums[h]) l = m + 1;
                else  h = m - 1;
            } else if (nums[m] > nums[h]) {
                if (nums[l] <= target && nums[m] > target)  h = m - 1;
                else  l = m + 1;  
            } else {
                h--;
            }
        }
        return false;
    }

}
