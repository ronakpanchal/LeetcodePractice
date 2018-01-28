package com.leetcode.problems;

import java.util.Stack;

public class BasicCalculatorII {

	public static void main(String[] args) {
		BasicCalculatorII obj = new BasicCalculatorII();
		System.out.println(obj.calculate("3+2*2"));
	}

	public int calculate(String s) {
		s = s.trim();
        int len;
        if(s==null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if (s.charAt(i) == ' ') continue;
            if (Character.isDigit(s.charAt(i))) {
                num = (num * 10) + (s.charAt(i) - '0');
            }
            if((!Character.isDigit(s.charAt(i))) || i==len-1){
                if(sign=='-') stack.push(-num);
                if(sign=='+') stack.push(num);
                if(sign=='*') stack.push(stack.pop() * num);
                if(sign=='/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack) re += i;
        return re;
	}

}
