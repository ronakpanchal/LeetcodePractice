package com.leetcode.problems;

public class RotateList {
	
	
	public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null) return head;
        int len = getLengthOfList(head);
        k = k % len;
        if (k == 0) return head;
        ListNode node = getKthNodeFromEnd(head, k);   
        ListNode newHead = node.next;
        ListNode current = newHead;
        node.next = null;
        while (current.next != null) current = current.next;
        current.next = head;
        return newHead;
    }
    
    private ListNode getKthNodeFromEnd(ListNode head, int k) {
        ListNode fp = head;
        ListNode sp = head;
        int count = 0;
        while (count++ < k) fp = fp.next;
        while (fp.next != null) {
            fp = fp.next;
            sp = sp.next;
        }
        return sp;
    }
    
    private int getLengthOfList(ListNode head) {
        return head == null?0:1 + getLengthOfList(head.next);
    }

}
