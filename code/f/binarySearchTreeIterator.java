// https://leetcode.com/explore/interview/card/facebook/56/design-3/303/

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
class BSTIterator {
    
    Stack<TreeNode> stack;
    TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
        pushLeftSide(root);
    }
    
    private void pushLeftSide(TreeNode root) {
        TreeNode curr = root;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        if(!hasNext()) return -1;
        
        TreeNode curr = stack.pop();
        if(curr.right != null) pushLeftSide(curr.right);

        return curr.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
