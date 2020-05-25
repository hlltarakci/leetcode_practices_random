// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/544/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(n) -- worst case
    */
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
    
        Stack<Node> stack = new Stack<>();
        Node head=null, prev=null, curr=root;
        while(true) {
            while(curr!= null) {
                stack.push(curr);
                curr = curr.left;
            }
            if(!stack.isEmpty()) {
                curr = stack.pop();
                if(prev == null) head = curr;
                else prev.right = curr;
                
                curr.left = prev;
                
                prev = curr;
                if(curr.right != null) curr = curr.right;
                else curr = null;
            } else break;
        }
        
        prev.right = head;
        head.left = prev;
        
        return head;
    }
}
