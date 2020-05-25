// https://leetcode.com/explore/interview/card/facebook/6/linked-list/3021/

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return ;
        
        ListNode curr = head;
        while(curr.next != null && curr.next.next != null) curr = curr.next;
        
        ListNode finalNode = curr.next;
        curr.next = null;
        
        finalNode.next = head.next;
        head.next = finalNode;
        
        reorderList(finalNode.next);
    }
}
