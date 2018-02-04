package com.leetcode.problems;

import java.util.Stack;

public class MaximalRectangle {
	
	public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = largestRectangleArea(matrix[0]);
        for (int i = 1;i < matrix.length;i++) {
            for (int j = 0;j < matrix[0].length;j++) {
                if (matrix[i][j] == '1') {
                    matrix[i][j] = (char)(((matrix[i - 1][j] - '0') + 1) + '0');
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(matrix[i]));
        }
        return maxArea;
    }
    
     public int largestRectangleArea(char[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int area = 0;
        int maxArea = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (i < heights.length) {
            if (stack.isEmpty() || (heights[stack.peek()] - '0') <= (heights[i] - '0')) {
                stack.push(i++);
            } else {
                int index = stack.pop();
                area = (heights[index] - '0') * (stack.isEmpty()?i:(i - stack.peek() - 1));
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            area = (heights[index] - '0')*(stack.isEmpty()?i:(i - stack.peek() - 1));
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
	}

}
