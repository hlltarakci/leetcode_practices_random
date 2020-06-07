// https://leetcode.com/problems/binary-tree-paths/

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(paths, root, "");
        return paths;
    }
    
    private void binaryTreePaths(List<String> paths, TreeNode root, String path) {
        if(root == null) return;
        
        path += root.val;
        
        if(root.left == null && root.right == null) 
            paths.add(path);
        else {
            path += "->";
            binaryTreePaths(paths, root.left, path);
            binaryTreePaths(paths, root.right, path);
        }
    }
}
