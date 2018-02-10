package com.leetcode.problems;

public class SymmetricTree {
	
	 	public boolean isSymmetric(TreeNode root) {
	        if (root == null) return true;
	        return isSame(root, root);
	    }
	    
	    boolean isSame(TreeNode root1, TreeNode root2) {
	        if (root1 == null && root2 == null) return true;
	        else if (root1 == null || root2 == null || root1.val != root2.val) return false;
	        else return isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
	    }

}
