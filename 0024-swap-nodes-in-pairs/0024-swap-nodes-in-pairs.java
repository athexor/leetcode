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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode temp = head;
        ListNode newHead = temp.next;
        ListNode prevGroupTail = null;

        while(temp != null && temp.next != null){
            ListNode oldGroupHead = temp;
            ListNode newGroupHead = swap(temp, temp.next);

            if(prevGroupTail != null)
                prevGroupTail.next = newGroupHead;

            prevGroupTail = oldGroupHead;
            temp = newGroupHead.next.next;
        }
        
        return newHead;
    }

    public ListNode swap(ListNode temp1, ListNode temp2){
        temp1.next = temp2.next;
        temp2.next = temp1;
        return temp2;
    }
}