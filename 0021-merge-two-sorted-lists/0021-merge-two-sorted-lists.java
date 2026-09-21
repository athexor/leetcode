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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;

        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode temp3 = null;
        
        if(list1.val <= list2.val){
            temp3 = temp1;
            temp1 = temp1.next;
        }else{
            temp3 = temp2;
            temp2 = temp2.next;
        }

        ListNode list3 = temp3;

        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp3.next = temp1;
                temp1 = temp1.next;
            }else{
                temp3.next = temp2;
                temp2 = temp2.next;
            }
            temp3 = temp3.next;
        }

        while(temp1 != null){
            temp3.next = temp1;
            temp1 = temp1.next;
            temp3 = temp3.next;
        }

        while(temp2 != null){
            temp3.next = temp2;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }

        return list3;
    }
}

/**
 * Approach: Two Pointers (Merge Step of Merge Sort).
 *
 * Line 18: else if(list2 == null) -> we can do only if as well instead of else if.
 *
 * Time Complexity: O(n + m) in all cases --
 *                   every node from both lists is visited and attached
 *                   to list3 exactly once. Even in the "lucky" case where
 *                   one list is fully smaller/larger than the other, the
 *                   trailing while loops still walk through the remaining
 *                   nodes one by one to relink them -- there's no shortcut
 *                   like "attach the rest of the list in O(1)", since each
 *                   node's `next` pointer must be individually reassigned.
 *
 * Space Complexity: O(1) --
 *                   no new nodes are created; existing nodes are relinked
 *                   in place using a constant number of pointers
 *                   (temp1, temp2, temp3, list3).
 */