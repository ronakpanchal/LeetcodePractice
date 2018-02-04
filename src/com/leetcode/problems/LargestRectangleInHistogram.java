package com.leetcode.problems;

import java.util.Stack;

public class LargestRectangleInHistogram {
	
	 public int largestRectangleArea(int[] heights) {
	        if (heights == null || heights.length == 0) return 0;
	        int area = 0;
	        int maxArea = 0;
	        int i = 0;
	        Stack<Integer> stack = new Stack<Integer>();
	        while (i < heights.length) {
	            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
	                stack.push(i++);
	            } else {
	                int index = stack.pop();
	                area = heights[index] * (stack.isEmpty()?i:(i - stack.peek() - 1));
	                maxArea = Math.max(maxArea, area);
	            }
	        }
	        while (!stack.isEmpty()) {
	            int index = stack.pop();
	            area = heights[index]*(stack.isEmpty()?i:(i - stack.peek() - 1));
	            maxArea = Math.max(maxArea, area);
	        }
	        return maxArea;
	    }

}
