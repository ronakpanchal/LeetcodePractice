package com.leetcode.problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FourSum {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < 4) return Collections.emptyList();
        Arrays.sort(nums);
        for (int i = 0;i < n - 3;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) return result;
            for (int j = i + 1;j < n - 2;j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
                int l = j + 1;
                int h = n - 1;
                while (l < h) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[h];
                    if (sum == target) {
                        result.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[l], nums[h]}));
                        while (l < h && nums[l] == nums[l + 1]) l++;
                        while (l < h && nums[h] == nums[h - 1]) h--;
                        l++;
                        h--;
                    } else if (sum > target) {
                        h--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return result;
    }

}
