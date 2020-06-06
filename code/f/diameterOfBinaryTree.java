// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/291/

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
class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(n) -- tree height could go up to n for unbalanced tree
    */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    
    private int depth(TreeNode root) {
        if(root == null) return -1;
       
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        
        int d = 0;
        if(leftDepth >= 0) d += leftDepth + 1;
        if(rightDepth >= 0) d += rightDepth + 1;
        
        max = Math.max(d, max);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
