package com.leetcode.problems;

import java.util.Stack;

public class KthSmallestInBST {

	public int kthSmallest(TreeNode root, int k) {
		if (root == null) return 0;
		TreeNode curr = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		int cnt = 1;
		while (curr != null) {
			s.push(curr);
			curr = curr.left;
		}
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			if (cnt++ == k) return node.val;
			TreeNode treeNode = node.right;
			while (treeNode != null) {
				s.push(treeNode);
				treeNode = treeNode.left;
			}
		}
		return -1;
	}

}
