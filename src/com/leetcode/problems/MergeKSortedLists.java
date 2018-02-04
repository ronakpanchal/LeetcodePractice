package com.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
	
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
		    public int compare(ListNode a, ListNode b) {
			return a.val - b.val;
		    }
		});
		for (ListNode node:lists) {
		    if (node != null) pq.add(node);
		}
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!pq.isEmpty()) {
		    ListNode node = pq.poll();
		    p.next = node;
		    if (node.next != null) {
			pq.add(node.next);
		    }
		    p = p.next;
		}
		return dummy.next;
    	}

}
