package com.leetcode.problems;

public class InorderSucessorInBST {
	
	 public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        if (p == null) return root;
	        if (p.right != null) {
	            TreeNode curr = p.right;
	            while (curr.left != null) curr = curr.left;
	            return curr;
	        }
	        TreeNode curr = root;
	        TreeNode result = null;
	        while (curr != null) {
	            if (curr.val == p.val) return result;
	            else if (curr.val > p.val) {result = curr;curr = curr.left;}
	            else curr = curr.right;
	        }
	        return result;
	  }

}
