package com.leetcode.problems;

public class ClosestBinarySearchTreeValue {
	
	public int closestValue(TreeNode root, double target) {
        double minDiff = Double.MAX_VALUE;
        double result = 0;
        TreeNode curr = root;
        while (curr != null) {
            if (Math.abs(curr.val - target) < minDiff) {
                minDiff = Math.abs(curr.val - target);
                result = curr.val;
            } 
            if (curr.val == target) {
                return curr.val;
            } else if (curr.val > target) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return (int)result;
    }

}
