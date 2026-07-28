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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode prev = null;
        
        while(temp != null){    
            ListNode next = null;
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }   

        return prev;
    }
}

/**
 * Declare 'next' inside the loop because it is only needed for the current iteration.
 * We could declare it outside the loop, but its actual usage is limited to the loop.
 * Keeping it inside limits its scope and makes the code easier to understand.
 */