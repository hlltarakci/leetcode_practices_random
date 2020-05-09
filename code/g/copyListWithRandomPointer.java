/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    /*
      https://leetcode.com/problems/copy-list-with-random-pointer/
      
      n: number of nodes
      time: O(n)
      space: O(1) - excluding output
      
      ! pay attention to separate out the orig and clone lists before returning
    */
    public Node copyRandomList(Node head) {
        // corner case
        if(head == null) return null;
        
        // create clones in between nodes
        Node current = head;
        while(current != null) {
            // create the clone
            Node clone = new Node(current.val, current.next, current.random);
            
            // tie current to clone
            current.next = clone;
            
            // iterate to next in original list
            current = clone.next;
        }
        
        // adjust random pointers of clone list
        current = head.next;
        while(current != null ) {
            current.random = current.random != null ? current.random.next : null;
            current = current.next != null ? current.next.next : null;
        }
        
        // keep cloneHead
        Node cloneHead = head.next;
        
        // seperate orig and clone lists
        Node origN = head, cloneN = cloneHead;
        while(origN != null && cloneN != null) {
            Node origNext = origN.next != null ? origN.next.next : null;
            Node cloneNext = cloneN.next != null ? cloneN.next.next : null;
            
            origN.next = origNext;
            cloneN.next = cloneNext;
            
            origN = origN.next;
            cloneN = cloneN.next;
        }
        
        return cloneHead;
    }
}
