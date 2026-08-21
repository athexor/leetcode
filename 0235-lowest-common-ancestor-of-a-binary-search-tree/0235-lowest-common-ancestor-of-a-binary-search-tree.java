/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode A, TreeNode B, TreeNode C) {
        if(A == null)
            return A;

        TreeNode temp = A;

        while(temp != null){
            if(B.val > temp.val && C.val > temp.val)
                temp = temp.right;
            else if(B.val < temp.val && C.val < temp.val)
                temp = temp.left;
            else
                return temp;
        }

        return temp;
    }
}