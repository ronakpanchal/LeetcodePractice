package com.leetcode.problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MajorityElementII {
	
	public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<Integer>();
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == candidate1) count1++;
            else if (nums[i] == candidate2)count2++;
            else if (count1 == 0) {
                count1 = 1;
                candidate1 = nums[i];
            } else if (count2 == 0) {
                count2 = 1;
                candidate2 = nums[i];
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] == candidate1) {
                count1++;
            } else if (nums[i] == candidate2) {
                count2++;
            }
        }
        if (count1 > (nums.length / 3)) result.add(candidate1);
        if (count2 > (nums.length/ 3)) result.add(candidate2);
        return result;
    }

}
