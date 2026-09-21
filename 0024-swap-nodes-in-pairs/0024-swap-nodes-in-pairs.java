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
            ListNode newGroupHead = swap(temp, temp.next);

            if(prevGroupTail != null)
                prevGroupTail.next = newGroupHead;

            prevGroupTail = temp;
            temp = temp.next;
        }
        
        return newHead;
    }

    public ListNode swap(ListNode temp1, ListNode temp2){
        temp1.next = temp2.next;
        temp2.next = temp1;
        return temp2;
    }
}

/**
 * Approach: Iterative pairwise swap using a helper swap() function,
 * stitching each swapped pair to the previous one via prevGroupTail.
 *
 * Line 13: if(head == null || head.next == null) -> nothing to swap when
 * the list is empty or has only one node, so return head as-is.
 *
 * Time Complexity: O(n) in all cases --
 *                   each node is visited and processed exactly once,
 *                   regardless of node values.
 *
 * Space Complexity: O(1) --
 *                   no extra data structures; pairs are swapped in place
 *                   using a constant number of pointers.
 */