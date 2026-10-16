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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        ListNode temp = null;

        int pos = 1;
        int n=0;
        while(curr != null){
            if(pos == k)
                temp = curr;

            curr = curr.next;
            pos++;
            n++;
        }
        curr = head;

        int lastIndex = n-k;
        int currIndex = 0;
        while(curr != null && currIndex <= lastIndex -1){
            curr = curr.next;
            currIndex++;
        }   

        int tempValue = temp.val;
        temp.val = curr.val;
        curr.val = tempValue;

        return head;
    }
}