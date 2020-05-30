// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/322/

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
        h: tree height -- log n for balanced, n for unbalanced
        time: O(n)
        space: O(h)
    */
    public void flatten(TreeNode root) {
        root = flattenRec(root);
    }
    
    public TreeNode flattenRec(TreeNode root) {
        if(root == null) return root;
        
        System.out.println(root.val);
        
        TreeNode left = flattenRec(root.left);
        TreeNode right = flattenRec(root.right);
        
        root.left = null;
        root.right = left;
        
        TreeNode curr = root;
        while(curr != null && curr.right != null) curr = curr.right;
        
        curr.right = right;
        
        return root;
    }
}
