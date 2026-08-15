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
    public ListNode sortList(ListNode A) {
        return mergeSort(A);
    }

    public ListNode mergeSort(ListNode A){
        if(A == null || A.next == null)
            return A;
        
        ListNode sP = A;
        ListNode fP = A;
        ListNode prev = null;

        while(fP != null && fP.next != null){
            prev = sP;
            sP = sP.next;
            fP = fP.next.next;
        }
        prev.next = null;

        ListNode left = mergeSort(A);
        ListNode right = mergeSort(sP);
        return merge(left, right);
    }

    public ListNode merge(ListNode A, ListNode B){
        if(A == null && B == null)
            return null;

        if(A == null)
            return B;
        
        if(B == null)
            return A;

        ListNode temp1 = A;
        ListNode temp2 = B;
        ListNode C = null;

        if(temp1.val <= temp2.val){
            C = temp1;
            temp1 = temp1.next;
        }else{
            C = temp2;
            temp2 = temp2.next;
        }

        ListNode temp3 = C;

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

        return C;
    }
}