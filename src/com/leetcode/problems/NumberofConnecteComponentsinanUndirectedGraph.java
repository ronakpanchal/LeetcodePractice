package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NumberofConnecteComponentsinanUndirectedGraph {
	
	
	public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int cnt = 0;
        for (int i = 0;i < n;i++) list.add(new ArrayList<Integer>());
        for (int i = 0;i < edges.length;i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0;i < n;i++) {
            if (!visited.contains(i)) {
                cnt++;
                q.add(i);
                visited.add(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (Integer neighbor:list.get(node)) {
                        if (visited.contains(neighbor)) continue;
                        q.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return cnt;
    }

}
