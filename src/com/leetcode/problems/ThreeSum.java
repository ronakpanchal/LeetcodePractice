package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0;i < n - 2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int h = n - 1;
            while (l < h) {
                int sum = nums[i] + nums[l]  + nums[h];
                if (sum == 0) {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[l], nums[h]}));
                    while (l < h && nums[l] == nums[l + 1]) l++;
                    while (l < h && nums[h] == nums[h - 1]) h--;
                    l++;
                    h--;
                } else if (sum > 0) {
                    h--;
                } else {
                    l++;
                }
            }
            
        }
        return result;
    }

}
