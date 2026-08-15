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
 * Done. No need to handle the head == null condition,
 * as the while loop already handles this case.
 *
 * In the brute force solution, we have to traverse n times first to count
 * the number of elements, then jump n/2 times starting from index 0:
 *
 * for (i = 0; i <= n/2 - 1; i++)
 *
 * i.e., jump = 0; jump <= n/2 - 1; jump++
 */