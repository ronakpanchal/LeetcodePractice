package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	
	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int runningSum = 0;
		for (int i = 0;i < nums.length;i++) {
		    runningSum += nums[i];
		    if (k != 0) runningSum = runningSum % k;
		    if (map.containsKey(runningSum)) {
			if (i - map.get(runningSum) > 1) return true;
		    } else {
			map.put(runningSum ,i);
		    } 
		}
		return false;
    	}

}
