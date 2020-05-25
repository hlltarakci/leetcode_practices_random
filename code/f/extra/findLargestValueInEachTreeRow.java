// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> maxs = new ArrayList<>();
        
        if(root == null) return maxs;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if(curr == null) {
                maxs.add(max);
                max = Integer.MIN_VALUE;
                if(!queue.isEmpty()) queue.add(null);
            } 
            else {
                max = Math.max(max, curr.val);
            
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        
        return maxs;
    }
}
