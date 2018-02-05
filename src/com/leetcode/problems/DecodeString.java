package com.leetcode.problems;

import java.util.Stack;

public class DecodeString {
	
	public String decodeString(String s) {
        String result = "";
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<String> s2 = new Stack<String>();
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int sum = 0;
                while (Character.isDigit(s.charAt(index))) {
                    char c = s.charAt(index);
                    sum = (sum * 10) + (c - '0');
                    index++;
                }
                s1.push(sum);
            } else if (s.charAt(index) == '[') {
                s2.push(result);
                result = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(s2.pop());
                int count = s1.pop();
                for (int i = 0;i < count;i++) {
                    sb.append(result);
                }
                result = sb.toString();
                index++;
            } else {
                result += s.charAt(index++);
            }
        }
        return result;
    }

}
