/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
      https://leetcode.com/problems/merge-k-sorted-lists/
      
      n: total number of nodes in all lists
      k: num of lists
      time: O(n log k)
      space: O(k) -- size of min heap
    */
    public ListNode mergeKLists(ListNode[] lists) {
        
        // dummy node to handle all list
        ListNode head = new ListNode(-1);
        
        // populate min heap
        PriorityQueue<ListNode> minHeap = populate(lists);
        
        ListNode current = head;
        while(!minHeap.isEmpty()) {
            ListNode next = minHeap.remove();
            
            // put rest of next back into minHeap
            if(next.next != null) minHeap.add(next.next);
            
            current.next = next;
            current = current.next;
        }
        
        return head.next;
    }
    
    private PriorityQueue<ListNode> populate(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>( (a, b) -> a.val - b.val );
        
        for(ListNode list: lists) {
            if(list != null) minHeap.add(list);
        }

        return minHeap;
    }
}
