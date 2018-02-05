package com.leetcode.problems;

public class SubtreeofAnotherTree {
	
 	public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null) return false;
        else return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null || s.val != t.val) return false;
        else return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

}
