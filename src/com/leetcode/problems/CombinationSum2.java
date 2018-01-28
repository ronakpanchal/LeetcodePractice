package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	
	
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSum2(candidates, result, new ArrayList<Integer>(), 0, target);
        return result;
    }
    
    private void combinationSum2(int[] nums, List<List<Integer>> result, List<Integer> list, int index, int target) {
        if (target == 0)  result.add(new ArrayList<Integer>(list));
        else if (target < 0) return;
        else {
            for (int i = index;i < nums.length;i++) {
                if (i > index && nums[i] == nums[i - 1]) continue;
                list.add(nums[i]);
                combinationSum2(nums, result, list, i + 1, target - nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }

}
