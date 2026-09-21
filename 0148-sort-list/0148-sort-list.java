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
    public ListNode sortList(ListNode head) {
        if(head == null)
            return head;

        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){
        if(head.next == null)
            return head;

        ListNode sP = head;
        ListNode fP = head;
        ListNode prev = null;

        while(fP != null && fP.next != null){
            prev = sP;
            sP = sP.next;
            fP = fP.next.next;
        }

        ListNode list1 = head;
        ListNode list2 = sP;
        prev.next = null;

        list1 = mergeSort(list1);
        list2 = mergeSort(list2);

        return mergeTwoLists(list1, list2);
    }

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
 * Approach: Merge Sort (Fast & Slow Pointers to split + mergeTwoLists to combine).
 *
 * Line 12: if(head == null) -> only needed in sortList (entry point) to
 * handle an empty list. mergeSort never receives a null head: list1 is
 * just `head` (non-null, since it passed the base case), and list2 is
 * `sP`, which always lands on a real node as it only advances while
 * fP/fP.next are non-null.
 *
 * Line 19: if(head.next == null) -> base case, a single node is already
 * "sorted", so recursion stops here.
 *
 * Line 60: else if(list2 == null) -> we can do only if as well instead of else if.
 *
 * Time Complexity: O(n log n) in all cases --
 *                   list is split in half at each level (log n levels),
 *                   and merging all sublists at each level costs O(n)
 *                   total. So n work * log n levels = O(n log n).
 *
 * Space Complexity: O(log n) --
 *                   no extra arrays/nodes allocated; recursive calls
 *                   to mergeSort add O(log n) stack frames, one per
 *                   split level.
 */