package com.leetcode.problems;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	
	private int index = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, preorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int l, int h) {
        if (l > h) {
            return null;
        } else if (h == l) {
            return new TreeNode(preorder[index++]);
        } else {
            int ind = -1;
            int val = preorder[index++];
            for (int i = l;i <= h;i++) {
                if (inorder[i] == val) {
                    ind = i;
                    break;
                }
            }
            TreeNode node = new TreeNode(val);
            node.left = buildTree(preorder, inorder, l , ind - 1);
            node.right = buildTree(preorder, inorder, ind + 1, h);
            return node;
        }
    }

}
