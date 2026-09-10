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

/**
 * No need to handle the head == null condition,
 * as the while loop already handles this case.
 *
 * If head is null:
 *     sP = null, fP = null
 *     while condition (fP != null) becomes false
 *     loop will not execute, sP (null) is returned directly.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */