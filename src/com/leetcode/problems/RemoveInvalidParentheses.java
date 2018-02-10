package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	
	 public List<String> removeInvalidParentheses(String s) {
	        List<String> result = new ArrayList<String>();
	        Queue<String> q = new LinkedList<String>();
	        Set<String> set = new HashSet<String>();
	        q.add(s);
	        boolean found = false;
	        while (!q.isEmpty()) {
	            String str = q.poll();
	            if (isValid(str)) {
	                result.add(str);
	                found = true;
	            }
	             if (found) continue;
	            for (int i = 0;i < str.length();i++) {
	                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
	                String newString = str.substring(0, i) + str.substring(i + 1, str.length());
	                if (!set.contains(newString)) {
	                      set.add(newString);
	                      q.add(newString);
	                }
	            }
	        }
	        return result;
	    }
	    
	    boolean isValid(String s) {
	        int cnt = 0;
	        for (char c:s.toCharArray()) {
	            if (c == '(') cnt++;
	            else if (c == ')') cnt--;
	            if (cnt < 0) return false;
	        }
	        return cnt == 0;
	    }

}
