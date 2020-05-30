// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/3022/

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
        h: tree height --- log n for balanced, n for unbalanced
        time: O(n)
        space: O(h)
    */
    long max = Long.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSumRec(root);
        return (int)max;
    }
    
    private long maxPathSumRec(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        
        long leftSum = maxPathSumRec(root.left);
        long rightSum = maxPathSumRec(root.right);
        
        max = Math.max(max, Math.max(leftSum, rightSum));
        if(leftSum > 0 && rightSum > 0)
            max = Math.max(max, leftSum + rightSum + root.val);
        
        long rootSum = Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
        
        max = Math.max(max, rootSum);
        
        return rootSum;
    }
}
