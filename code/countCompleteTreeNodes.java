// Approach 1

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
      https://leetcode.com/problems/count-complete-tree-nodes/
      approach is just trivial recursion
      
      we do not use the fact that tree is complete binary
      
      n: number of nodes in tree
      time: O(n)
      space: O(log n) -- recursion depth, since tree is complete binary, it should be balanced
    */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
}
