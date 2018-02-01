package com.leetcode.problems;

public class CountCompleteTreeNodes {

	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int lheight = getHeight(root.left);
		int rheight = getHeight(root.right);
		if (lheight == rheight) return (1 << lheight) + countNodes(root.right);
		else return (1 << rheight) + countNodes(root.left);
	}

	int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + getHeight(root.left);
	}

}
