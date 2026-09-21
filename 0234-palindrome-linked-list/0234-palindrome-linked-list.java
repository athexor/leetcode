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
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return false;
        if(head.next == null)
            return true;

        ListNode sP = head;
        ListNode fP = head;
        ListNode prev = null;
        while(fP != null && fP.next != null){
            prev = sP;
            sP = sP.next;
            fP = fP.next.next;
        }

        ListNode list1 = head;
        ListNode list2 = reverseLinkList(sP);
        prev.next = null;

        ListNode temp1 = list1; 
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null){
            if(temp1.val != temp2.val)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        } 

        return true;
    }

    public ListNode reverseLinkList(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
}

/**
/**
 * Approach: Fast & Slow Pointers + In-place Reversal.
 *
 * if(head == null) -> empty list, return false.
 * if(head.next == null) -> single-node list is trivially a palindrome,
 * return true. 
 * Also, without this check, prev.next = null would throw an error
 * for a single-node list, since prev stays null in that case.
 *
 * reverseLinkList(ListNode head) -> no explicit null check added here,
 * since it is always called with sP, which will never be null
 * (the slow pointer always lands on a valid node).
 *
 * list1 (first half) is always <= list2 (reversed second half) in length,
 * since for odd-length lists the middle node ends up in list2, not list1.
 * So temp1 always hits null first (or with temp2, if n is even), leaving
 * at most one leftover node in list2 -- which trivially matches itself.
 * That's why the old trailing while(temp1 != null ...) loop was dead code.
 *
 * Time Complexity: O(N)
 *                  - Finding the middle node takes O(N/2).
 *                  - Reversing the second half takes O(N/2).
 *                  - Comparing the two halves takes O(N/2).
 *                  - All linear passes, so overall O(N).
 *
 * Space Complexity: O(1)
 *                   - No extra data structure is used to store nodes;
 *                     only a fixed number of pointers (sP, fP, prev,
 *                     list1, list2, temp1, temp2) are maintained,
 *                     regardless of input size.
 */