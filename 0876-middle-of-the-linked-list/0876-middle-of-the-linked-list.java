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
    public ListNode middleNode(ListNode head) {
        ListNode sP = head;
        ListNode fP = head;

        while(fP != null && fP.next != null){
            sP = sP.next;
            fP = fP.next.next;
        }   

        return sP;
    }
}