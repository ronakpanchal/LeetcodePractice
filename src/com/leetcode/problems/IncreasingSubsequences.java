package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {

	public List<List<Integer>> findSubsequences(int[] nums) {
		if (nums.length == 0)return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		findSubsequences(nums, result, new ArrayList<Integer>(), 0);
		return result;
	}

	private void findSubsequences(int[] nums, List<List<Integer>> result, List<Integer> list, int index) {
		if (list.size() > 1) result.add(new ArrayList<Integer>(list));
		Set<Integer> used = new HashSet<Integer>();
		for (int i = index; i < nums.length; i++) {
			if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
				if (used.contains(nums[i])) continue;
				used.add(nums[i]);
				list.add(nums[i]);
				findSubsequences(nums, result, list, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

}
