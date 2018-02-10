package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingRanges obj = new MissingRanges();
		obj.findMissingRanges(new int[]{0, 1}, 0, 1);
	}
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
       for(int i : nums) {
           if(i > lower) res.add(lower+((i-1 > lower)?"->"+(i-1):""));
           if(i == upper) return res; // Avoid overflow
           lower = i+1;
       }
       if(lower <= upper) res.add(lower + ((upper > lower)?"->"+(upper):""));
       return res;
   }

}
