package com.leetcode.problems;

import java.util.Random;

public class KthLargestElementInArray {
	
	public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int h = nums.length - 1;
        Random r = new Random();
        while (l <= h) {
            int randIndex = l + r.nextInt(h - l + 1);
            swap(nums, randIndex, h);
            int pivot = nums[h];
            int low = l;
            for (int i = low;i < h;i++) {
                if (nums[i] >= pivot) swap(nums, i, low++);
            }
            swap(nums, low, h);
            if (low == k - 1) return nums[low];
            else if (low > k - 1) h = low - 1;
            else l = low + 1;
        }
        return -1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
