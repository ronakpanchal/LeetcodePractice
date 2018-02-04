package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	
	public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0;i < nums.length;i++) {
            sum += nums[i];
            if (sum == k) cnt++;
            if (map.containsKey(sum - k)) cnt += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }

}
