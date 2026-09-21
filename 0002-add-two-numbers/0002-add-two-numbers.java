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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = null;
        int carry = 0;

        while(temp1 != null || temp2 != null){
            int val1 = temp1 == null ? 0 : temp1.val;
            int val2 = temp2 == null ? 0 : temp2.val;

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            if(newHead == null){
                newHead = newNode;
                temp3 = newHead;
            }else{
                temp3.next = newNode;
                temp3 = temp3.next;
            }

            if(temp1 != null)
                temp1 = temp1.next;
            if(temp2 != null)
                temp2 = temp2.next;
        }

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            temp3.next = newNode;
        }

        return newHead;
    }
}

/*
 * Approach: Simulate digit-by-digit addition (elementary school addition),
 * building the result list node by node while tracking carry.
 *
 * Time Complexity: O(max(n, m)) in all cases --
 *                   n and m being the lengths of l1 and l2; every digit
 *                   position is visited exactly once regardless of values,
 *                   plus possibly one extra node for a final carry.
 *
 * Space Complexity: O(max(n, m)) --
 *                   for the newly created output list (not counting the
 *                   input lists), since the result has at most
 *                   max(n, m) + 1 digits.
 */