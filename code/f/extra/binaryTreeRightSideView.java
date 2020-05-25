// https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rights = new ArrayList<>();
        
        if(root == null) return rights;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if(curr == null) {
                if(!queue.isEmpty()) queue.add(null);
            } else {
                if(queue.peek() == null) rights.add(curr.val);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        
        return rights;
    }
}
