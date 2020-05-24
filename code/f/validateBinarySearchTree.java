// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/266/

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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if( min != null && root.val <= min || 
            max != null && root.val >= max) return false;
        
        return isValidBST(root.left, min, root.val) && 
            isValidBST(root.right, root.val, max);
    }
}
