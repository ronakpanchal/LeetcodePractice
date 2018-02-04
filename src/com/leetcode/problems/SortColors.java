package com.leetcode.problems;

public class SortColors {
	
	 public void sortColors(int[] nums) {
	        int lessThanOne = 0;
	        int equalToOne = 0;
	        int greaterThanOne = 0;
	        for (int i = 0;i < nums.length;i++) {
	            if (nums[i] == 1) equalToOne++;
	            else if (nums[i] < 1) lessThanOne++;
	            else greaterThanOne++;
	        }
	        
	        for (int i = 0;i < lessThanOne;i++) nums[i] = 0;
	        for (int i = 0;i < equalToOne;i++) nums[lessThanOne + i] = 1;
	        for (int i = 0;i < greaterThanOne;i++) nums[lessThanOne + equalToOne + i] = 2;
	        
	  }
	 
	 	public void sortColorsII(int[] nums) {
	        int low = 0;
	        int mid = 0;
	        int high = nums.length - 1;
	        while (mid <= high) {
	            if (nums[mid] == 0) {
	                swap(nums, mid, low);
	                low++;
	                mid++;
	            } else if (nums[mid] == 1) {
	                mid++;
	            } else {
	                swap(nums, mid, high);
	                high--;
	            }
	        }
	    }
	    
	    private void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }

}
