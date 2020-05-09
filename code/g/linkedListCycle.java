/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
      https://leetcode.com/problems/linked-list-cycle/
      
      n: num of nodes
      time: O(n)
      space: O(1)
      
      ! null checks are important..
    */
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode slow = head, fast = head.next;
        
        while(fast != null && fast.next != null && fast.next.next != null) {
            // pointers collide, means cycle
            if(slow == fast) return true;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}
