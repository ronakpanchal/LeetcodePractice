package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cnt = 0;
		for (Integer num1:A) {
		    for (Integer num2:B) {
			int sum = num1 + num2;
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		    }
		}
		for (Integer n1:C) {
		    for (Integer n2:D) {
			int sum = n1 + n2;
			if (map.containsKey(-sum) && map.get(-sum) > 0) {
			    cnt += map.get(-sum);
			}
		    }
		}
		return cnt;
    	}

}
