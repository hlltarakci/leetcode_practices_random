/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        https://leetcode.com/problems/diameter-of-binary-tree/
        recursion
        
        n: num of nodes in tree
        time: O(n) -- touched all nodes
        space: O(log n) -- recursion depth considering tree is balanced, since binary
            if tree is not balanced space can go up to O(n)
    */
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calcDiameter(root);
    
        return root == null ? 0 : maxDiameter-1;
    }
    
    private int calcDiameter(TreeNode node) {
        if( node == null ) return 0;
        
        int maxDiameterAtLeft = calcDiameter(node.left);
        int maxDiameterAtRight = calcDiameter(node.right);
        
        // consider possibility that diameter going through this node is the actual max
        maxDiameter = Math.max(maxDiameter, maxDiameterAtLeft + maxDiameterAtRight + 1);
        
        // return max diameter that goes through that node 
        return Math.max(maxDiameterAtLeft, maxDiameterAtRight) + 1;
    }
}
