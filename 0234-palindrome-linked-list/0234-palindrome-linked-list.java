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

        while(temp1 != null && temp1.next != null){
            if(temp1.val != temp1.next.val)
                return false;
            temp1 = temp1.next.next;
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
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */