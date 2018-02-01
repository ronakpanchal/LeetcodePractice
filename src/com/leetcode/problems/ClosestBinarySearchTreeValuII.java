package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValuII {
	
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val >= target) {
                stack1.push(curr);
                curr = curr.left;
            } else {
                stack2.push(curr);
                curr = curr.right;
            }
        }
        while (k-- > 0) {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                break;
            } else if (stack1.isEmpty()) {
                result.add(getNextPredecessor(stack2));
            } else if (stack2.isEmpty()) {
                result.add(getNextSuccessor(stack1));
            } else if (Math.abs(stack1.peek().val - target) < Math.abs(stack2.peek().val - target)) {
                result.add(getNextSuccessor(stack1));
            } else {
                result.add(getNextPredecessor(stack2));
            }
        }
        return result;
    }
    
    private int getNextPredecessor(Stack<TreeNode> stack) {
        TreeNode node = stack.pop();
        TreeNode curr = node.left;
        while (curr != null) {
            stack.push(curr);
            curr = curr.right;
        }
        return node.val;
    }
    
     private int getNextSuccessor(Stack<TreeNode> stack) {
        TreeNode node = stack.pop();
        TreeNode curr = node.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return node.val;
    }

}
