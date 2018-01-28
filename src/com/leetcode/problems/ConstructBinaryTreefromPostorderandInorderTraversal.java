package com.leetcode.problems;

public class ConstructBinaryTreefromPostorderandInorderTraversal {
	
	private static int index = 0;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         index = inorder.length-1;
         return buildTree(inorder,postorder,0,postorder.length-1);
    }
    
    public   TreeNode buildTree(int[] inorder,int[] postorder,int l,int h){
        if(l > h)return null;
        else if (l == h) return new TreeNode(postorder[index--]);
        else{
            int ind = 0;
            for(int i = l;i <= h;i++){
                if(postorder[index] == inorder[i]){
                    ind=i;
                    break;
                }
            }
            TreeNode root = new TreeNode(postorder[index--]);
            root.right = buildTree(inorder, postorder, ind + 1, h);
            root.left  = buildTree(inorder, postorder, l, ind - 1);
            return root;
        }
    }

}
