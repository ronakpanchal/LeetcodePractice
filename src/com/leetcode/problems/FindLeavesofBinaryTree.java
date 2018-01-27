package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindLeavesofBinaryTree {
	
	public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (root.left != null || root.right != null) {
            List<Integer> list = new ArrayList<Integer>();
            findLeaves(root, list);
            result.add(list);
        }
        result.add(Arrays.asList(new Integer[]{root.val}));
        return result;
    }
    
    private TreeNode findLeaves(TreeNode root, List<Integer> list) {
        if (root == null) {
            return null;
        } else if (root.left == null && root.right == null) {
            list.add(root.val);
            return null; 
        } else {
            root.left = findLeaves(root.left, list);
            root.right = findLeaves(root.right, list);
            return root;
        }
    }

}
