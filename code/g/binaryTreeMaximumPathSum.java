/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
  https://leetcode.com/problems/binary-tree-maximum-path-sum/
  
  n: number of tree nodes
  time: O(n)
  space: O(log n) -- recursion stack
   -- for worst case when tree is unbalanced it is O(n)
   -- it says binary tree, so it should be balanced i guess
*/
class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        inOrderTraverse(root);
        return max;
    }
    
    private int inOrderTraverse(TreeNode root) {
        if( root == null) return 0;
        
        int maxSumAtLeftNode = inOrderTraverse(root.left);
        int maxSumAtCurrentNode = Math.max(maxSumAtLeftNode + root.val, root.val); 
        int maxSumAtRightNode = inOrderTraverse(root.right);
        maxSumAtCurrentNode = Math.max(maxSumAtCurrentNode, maxSumAtCurrentNode + maxSumAtRightNode);
       
        // this could be the whole path, from left to right
        // so should consider this  
        max = Math.max(max, maxSumAtCurrentNode);
        
        // but we should see if the whole path is not this and path will continue upward,
        // so should choose left OR right or just the root value
        int maxAtNode = Math.max(root.val + maxSumAtLeftNode, root.val + maxSumAtRightNode);
        maxAtNode = Math.max(root.val, maxAtNode);
        
        return maxAtNode;
    }
    
}
