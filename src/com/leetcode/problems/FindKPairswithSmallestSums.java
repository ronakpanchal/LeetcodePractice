package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKPairswithSmallestSums {
	
	public static void main(String[] args) {
		FindKPairswithSmallestSums obj = new FindKPairswithSmallestSums();
		obj.kSmallestPairs(new int[]{1}, new int[]{3,5,6,7,8,100}, 4);
	}
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		if (nums1.length == 0 || nums2.length == 0) return Collections.emptyList();
		List<int[]> result = new ArrayList<int[]>();
		Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
		    public int compare(int[] a, int[] b) {
			return a[0] + a[1] - b[0] - b[1];
		    }
		});
		for (int i = 0;i < nums2.length;i++) pq.add(new int[]{nums1[0], nums2[i], 0});
		while (k-- > 0 && !pq.isEmpty()) {
		    int[] arr = pq.poll();
		    result.add(new int[]{arr[0], arr[1]});
		    if (arr[2] == nums1.length - 1) continue;
		    pq.add(new int[]{nums1[arr[2] + 1], arr[1], arr[2] + 1});
		}
		return result;
    	}

}
