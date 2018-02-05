package com.leetcode.problems;

public class DiameterOfBinaryTree {
	
	public int diameterOfBinaryTree(TreeNode root) {
	        if (root == null) return 0;
	        return diameter(root)[1] - 1;
	    }
	    
	    int[] diameter(TreeNode root) {
	        if (root == null) return new int[]{0, 0};
	        int[] ld = diameter(root.left);
	        int[] rd = diameter(root.right);
	        int height = Math.max(ld[0], rd[0]) + 1;
	        int finalDiameter = Math.max(Math.max(ld[1], rd[1]), ld[0] + rd[0] + 1);
	        return new int[]{height, finalDiameter};
	    }

}
