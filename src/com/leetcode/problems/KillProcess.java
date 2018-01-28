package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KillProcess {
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0;i < ppid.size();i++) {
            int childId = pid.get(i);
            int parentId = ppid.get(i);
            List<Integer> list = map.getOrDefault(parentId, new ArrayList<Integer>());
            list.add(childId);
            map.put(parentId, list);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(kill);
        while (!q.isEmpty()) {
            int id = q.poll();
            result.add(id);
            if (map.containsKey(id))q.addAll(map.get(id));
        }
        return result;
    }

}
