package com.leetcode.problems;

public class MaximumSumofThreeNonOverlappingSubarrays {
	
	 public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
	    int len = nums.length - k + 1;
	    int[] w = new int[len];
	    int[] left = new int[len];
	    int[] right = new int[len];
	    int[] ans = {-1, -1, -1};
	    int sum = 0;
	    for (int i = 0;i < nums.length;i++) {
	        sum += nums[i];
	        if (i >= k) sum -= nums[i - k];
	        if (i >= k - 1) w[i - k + 1] = sum;
	    }
	    int best = 0;
	    for (int i = 0;i < w.length;i++) {
	        if (w[i] > w[best]) best = i;
	        left[i] = best;
	    } 
	    best = w.length - 1;
	    for (int i = w.length - 1;i >= 0;i--) {
	        if (w[i] > w[best]) best = i;
	        right[i] = best;
	    }
	    for (int i = k;i < w.length - k;i++) {
	        int total = w[i] + w[left[i - k]] + w[right[i + k]];
	        if (ans[0] == -1 || total > w[ans[0]] + w[ans[1]]+ w[ans[2]]) {
	            ans[0] = left[i - k];
	            ans[1] = i;
	            ans[2] = right[i + k];
	        }
	    }
	    return ans;
	    }

}
