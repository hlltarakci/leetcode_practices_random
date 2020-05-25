// https://leetcode.com/explore/interview/card/facebook/6/linked-list/319/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
        m, n: node counts
        time: O(max(m, n))
        space: O(max(m, n)) -- for output
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        
        int carry = 0;
        ListNode curr = dummy;
        while(l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            curr.next = node;
            
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry > 0) curr.next = new ListNode(carry);
        
        return dummy.next;
    }
}
