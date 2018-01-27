package com.leetcode.problems;

import java.util.Stack;

public class SerializeDeserializeBinarySearchTree {

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) return "";
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			sb.append(node.val).append(" ");
			if (node.right != null) s.push(node.right);
			if (node.left != null) s.push(node.left);
		}
		return sb.toString().trim();
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty()) return null;
		String[] str = data.split(" ");
		return deseralize(str, 0, str.length - 1);
	}

	private TreeNode deseralize(String[] data, int low, int high) {
		if (low > high)return null;
		else if (low == high)return new TreeNode(Integer.parseInt(data[low]));
		TreeNode root = new TreeNode(Integer.parseInt(data[low]));
		int l = low + 1;
		while (l <= high && Integer.parseInt(data[l]) < Integer.parseInt(data[low]))l += 1;
		root.left = deseralize(data, low + 1, l - 1);
		root.right = deseralize(data, l, high);
		return root;
	}

}
