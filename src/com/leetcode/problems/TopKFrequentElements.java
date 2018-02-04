package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Integer> pq  = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            } 
        });
        for (Integer num:nums) map.put(num, map.getOrDefault(num, 0) + 1);
        Iterator<Integer> itr = map.keySet().iterator();
        while (itr.hasNext()) pq.add(itr.next());
        while (list.size() < k && !pq.isEmpty()) list.add(pq.poll());
        return list;
    }

}
