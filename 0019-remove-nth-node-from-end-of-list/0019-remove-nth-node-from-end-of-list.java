/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return head;
        }

        ListNode temp = head;
        int i = 0;

        while (temp != null) {
            temp = temp.next;
            i++;
        }

        int j = i - n;

        if (j == 0) {
            head = head.next;
            return head;
        }

        temp = head;
        int pos = 0;

        while (temp != null && pos <= j - 2) {
            temp = temp.next;
            pos++;
        }

        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }
}