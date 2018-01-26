package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	
	 public List<Integer> majorityElement(int[] nums) {
	        List<Integer> result = new ArrayList<Integer>();
	        int c1 = 0, c2 = 0, count1 = 0, count2 = 0;
	        for (int i = 0;i < nums.length;i++) {
	            if (nums[i] == c1) count1++;
	            else if (nums[i] == c2)count2++;
	            else if (count1 == 0) {count1 = 1;c1 = nums[i];}
	            else if (count2 == 0) {count2 = 1;c2 = nums[i];}
	            else {count1--;count2--;}
	        }
	        count1 = 0;
	        count2 = 0;
	        for (int i = 0;i < nums.length;i++) {
	            if (nums[i] == c1) count1++;
	            if (nums[i] == c2) count2++;
	        }
	        if (count1 > (nums.length / 3)) result.add(c1);
	        if (c1 == c2) return result;
	        if (count2 > (nums.length / 3)) result.add(c2);
	        return result;
	    }

}
