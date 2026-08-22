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
        if(!found(A, B) || !found(A, C))
            return null;

        TreeNode ans = traverse(A, B, C);

        return (ans != null) ? ans : null;
    }

    public boolean found(TreeNode A, TreeNode B){
        if(A == null)
            return false;
        
        if(A.val == B.val)
            return true;

        return found(A.left, B) || found(A.right, B);
    }

    public TreeNode traverse(TreeNode A, TreeNode B, TreeNode C){
        if(A == null || A.val == B.val || A.val == C.val )
            return A;

        TreeNode left = traverse(A.left, B, C);
        TreeNode right = traverse(A.right, B, C);

        if(left != null && right != null)
            return A;
        
        return left != null ? left : right;
    }
}