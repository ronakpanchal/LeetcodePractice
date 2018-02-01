package com.leetcode.problems;

public class SumRootToLeafNumbers {
	
	public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    int sumNumbers(TreeNode root, int sum) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return (sum * 10) + root.val;
        else {
            int val = (sum * 10) + root.val;
            return sumNumbers(root.left, val) +sumNumbers(root.right, val);
        }
    }

}
