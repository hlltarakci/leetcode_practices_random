// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(n) --> recursion stack at worst case - in case there is a chain of children
    */
    public Node flatten(Node head) {
        if(head == null) return null;
        
        Node curr = head;
        while(curr != null) {
            Node child = flatten(curr.child);
            if(child != null) {
                child.prev = curr;
                Node currChild = child;
                while(currChild != null && currChild.next != null) currChild = currChild.next;
                currChild.next = curr.next;
                if(currChild.next != null) currChild.next.prev = currChild;
                curr.next = child;
                curr.child = null;
            }
            curr = curr.next;
        }
        
        return head;
    }
}
