package com.vlat.medium;

/*
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

//Runtime 1 ms Beats 99.91%
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        var res = calcSum(root, targetSum);
        return (res == null)? new ArrayList<>(): res;
    }

    private List<List<Integer>> calcSum(TreeNode node,int sumNeed){
        if(node == null) return null;
        if(node.left == null && node.right == null){
            if(sumNeed - node.val == 0){
                List<List<Integer>> list = new LinkedList<>();
                List<Integer> nl = new ArrayList<>();
                nl.add(node.val);
                list.add(nl);
                return list;
            }
            return null;
        }
        sumNeed -= node.val;
        var leftLi = calcSum(node.left, sumNeed);
        var rightLi = calcSum(node.right, sumNeed);

        if(leftLi == null) leftLi = rightLi;
        else if(rightLi != null){
            leftLi.addAll(rightLi);
        }

        if(leftLi != null){
            for(var l:leftLi){
                l.addFirst(node.val);
            }
        }
        return leftLi;
    }


    class TreeNode {
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
