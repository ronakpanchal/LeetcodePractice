package com.leetcode.problems;

import java.util.Stack;

public class TernaryExpressionParser {
	
	public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return ""; 
        Stack<Character> stack = new Stack<Character>();
        for (int i = expression.length() - 1;i >= 0;i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char c1 = stack.pop();
                 stack.pop(); 
                char c2 = stack.pop();
                if (c == 'F') {
                    stack.push(c2);
                } else {
                    stack.push(c1);
                }
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.peek());
    }

}
