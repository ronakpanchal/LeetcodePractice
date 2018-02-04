package com.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        int[] result = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0;i < k;i++) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.add(i);
        }
        for (int i = k;i < n;i++) {
            result[i - k] = nums[q.peek()];
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            while (!q.isEmpty() && q.peek() < i - k + 1) q.pollFirst();
            q.add(i);
        }
       result[result.length - 1] = nums[q.peek()];
        return result;
    }

}
