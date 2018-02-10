package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class JourneyToMoon {
	
	public int journeyToMoon(int n, int[][] astronaut) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0;i < n;i++) list.add(new ArrayList<Integer>());
        for (int[] arr:astronaut) {
            int a = arr[0];
            int b = arr[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int result = 0;
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> counts = new ArrayList<Integer>();
        for (int i = 0;i < n;i++) {
            int cnt = 0;
            if (!visited.contains(i)) {
                q.add(i);
                visited.add(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    cnt++;
                    for (Integer child:list.get(node)) {
                        if (visited.contains(child)) continue;
                        visited.add(child);
                        q.add(child);
                    }
                }
                counts.add(cnt);
            }
        }
        for (int i = 0;i < counts.size();i++) {
            for (int j = i + 1;j < counts.size();j++) result += (counts.get(i) * counts.get(j));
        }
        return result;
    }

}
