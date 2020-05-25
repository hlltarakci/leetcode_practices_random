// https://leetcode.com/problems/next-greater-node-in-linked-list/

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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        
        int[] res = new int[list.size()];
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < list.size(); i++) {
            while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i))
                res[stack.pop()] = list.get(i);
            
            stack.push(i); 
        }
        
        return res;
    }
}
