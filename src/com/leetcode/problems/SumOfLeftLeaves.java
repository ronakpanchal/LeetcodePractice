package com.leetcode.problems;

public class SumOfLeftLeaves {
	
	public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }
    
    int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return isLeft?root.val:0;
        else return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    } 

}
