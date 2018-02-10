package com.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0;i < size;i++) {
                TreeNode treeNode = q.poll();
                if (treeNode.left != null) q.add(treeNode.left);
                if (treeNode.right != null) q.add(treeNode.right);
                list.add(treeNode.val);
            }
            result.add(list);
        }
        return result;
    }

}
