// https://leetcode.com/explore/interview/card/facebook/6/linked-list/3020/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /*
        n: node count
        time: O(n)
        space: O(n) -- for output
    */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        // clone all
        Node curr = head;
        while(curr != null) {
            Node clone = new Node(curr.val);
            clone.random = curr.random;
            clone.next = curr.next;
            curr.next = clone;
            
            curr = curr.next.next;
        }
        
        // assign randoms correct
        curr = head.next;
        while(curr != null) {
            curr.random = curr.random != null ? curr.random.next : null;
            
            curr = curr.next != null ? curr.next.next : null;
        }
        
        // seperate clone and orig lists
        Node cloneHead = head.next;
        curr = head;
        while(curr != null && curr.next != null) {
            Node next = curr.next;
            
            curr.next = curr.next.next;
            
            curr = next;
        }
        
        
        return cloneHead;
    }
}
