package com.vlat.easy;

/*
Given a binary tree, determine if it is height-balanced.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
           return checkNode(root) != -1;
    }

    private int checkNode(TreeNode node){
        if (node == null) return 0;
        int depth = 1;
        if (node.left != null || node.right != null){
            int leftDepth = 0, rightDepth = 0;
            if(node.left != null){
                leftDepth = checkNode(node.left);
                if (leftDepth == -1) return -1;
            }
            if(node.right != null){
                rightDepth = checkNode(node.right);
                if (rightDepth == -1) return -1;
            }
            if(Math.abs(leftDepth - rightDepth) > 1) return -1;
            depth += Math.max(leftDepth, rightDepth);
        }

        return depth;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
