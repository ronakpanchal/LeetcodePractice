package com.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

	public static void main(String[] args) {
		OpenTheLock obj = new OpenTheLock();
		obj.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
	}
	
	public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<String>();
        for (String str:deadends) set.add(str);
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        q.add("0000");
        map.put("0000", 0);
        while (!q.isEmpty()) {
            String ss = q.poll();
            char[] arr1 = ss.toCharArray();
            char[] arr2 = ss.toCharArray();
            if (set.contains(ss)) continue;
            if (ss.equals(target)) return map.get(ss);
            for (int i = 0;i < arr1.length;i++) {
                int digit = arr1[i] - '0';
                if (digit + 1 > 9) arr1[i] = '0';
                else  arr1[i] = (char)((digit + 1) + '0');
                String next = String.valueOf(arr1);
                if (!visited.contains(next)) {
                    q.add(next);
                    visited.add(next);
                    map.put(next, map.get(ss) + 1);
                }
                arr1[i] = (char)(digit + '0');
            } 
            for (int i = 0;i < arr2.length;i++) {
                int digit = arr2[i] - '0';
                if (digit - 1 < 0) arr2[i] = '9';
                else  arr2[i] = (char)((digit - 1) + '0');
                String next = String.valueOf(arr2);
                if (!visited.contains(next)) {
                    q.add(next);
                    visited.add(next);
                    map.put(next, map.get(ss) + 1);
                }
                arr2[i] = (char)(digit + '0');
            } 
        }
        return -1;
    }

}
