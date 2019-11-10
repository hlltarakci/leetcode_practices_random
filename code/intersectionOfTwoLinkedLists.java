/**
 * Definition for singly-linked list.
 * public class ListNode {
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
      https://leetcode.com/problems/intersection-of-two-linked-lists/
      
      a, b: number of nodes in given lists
      time: O(a + b)
      space: O(1)
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = calcLen(headA);
        int lenB = calcLen(headB);
        
        ListNode smaller = lenA < lenB ? headA : headB;
        ListNode larger = lenA < lenB ? headB : headA;
        
        // go extra mile in larger
        int extraNodeCount = Math.abs(lenA-lenB);
        while( extraNodeCount-- > 0)  larger = larger.next;
        
        // at this point, they are equal height
        // go check one-by-one
        while(larger != null) {
            if(larger == smaller) return larger;
            
            larger = larger.next;
            smaller = smaller.next;
        }
        
        return null;
    }
    
    private int calcLen(ListNode head) {
        int count = 0;
        
        while(head != null) {
            count++;
            head = head.next;
        }
        
        return count;
    }
}
