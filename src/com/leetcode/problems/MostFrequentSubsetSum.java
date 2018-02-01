package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MostFrequentSubsetSum {
	
	
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Queue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>(){
        public int compare(Integer a, Integer b) {
            return map.get(b) - map.get(a);
        }
    });

    public int[] findFrequentTreeSum(TreeNode root) {
        generateAllSum(root);
        int max = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> itr = map.keySet().iterator();
        while (itr.hasNext()) q.add(itr.next());
        while (!q.isEmpty()) {
           int sum = q.poll();
           if (max == Integer.MIN_VALUE) {
               max = map.get(sum);
           } else {
               if (map.get(sum) != max) break;
           }
            result.add(sum);
        }
        int[] arr = new int[result.size()];
        for (int i = 0;i < arr.length;i++) arr[i] = result.get(i);
        return arr;
         
    }
    
    private void generateAllSum (TreeNode root) {
        if (root == null) return;
        generateAllSum(root.left);
        generateAllSum(root.right);
        int sum = root.val;
        if (root.left != null) sum += root.left.val;
        if (root.right != null) sum += root.right.val;
        root.val = sum;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

}
