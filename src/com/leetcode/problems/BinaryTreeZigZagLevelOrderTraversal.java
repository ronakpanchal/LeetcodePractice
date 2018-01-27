package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigZagLevelOrderTraversal {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
		    List<Integer> list = new ArrayList<Integer>();
		    if (!s1.isEmpty()) {
		       while (!s1.isEmpty()) {
			   TreeNode node = s1.pop();
			   list.add(node.val);
			   if (node.left != null) s2.push(node.left);
			   if (node.right != null) s2.push(node.right);
		       } 
		    } else {
			 while (!s2.isEmpty()) {
			   TreeNode node = s2.pop();
			   list.add(node.val);
			   if (node.right != null) s1.push(node.right);
			   if (node.left != null) s1.push(node.left);
		       } 
		    }
		    result.add(list);
		}
		return result;
    }

}
