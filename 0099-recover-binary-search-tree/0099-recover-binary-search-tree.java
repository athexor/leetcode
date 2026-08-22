/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;

        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode secound = null;

        while(curr != null){
            if(curr.left != null){
                TreeNode temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }

                if(temp.right == null){
                    temp.right = curr;
                    curr = curr.left;
                }else{
                    temp.right = null;
                    if(prev != null && prev.val > curr.val){
                        if(first == null)
                            first = prev;
                        secound = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }else{
                if(prev != null && prev.val > curr.val){
                    if(first == null)
                        first = prev;
                    secound = curr;
                }
                prev = curr;
                curr = curr.right;
            }
        }

        int temp = first.val;
        first.val = secound.val;
        secound.val = temp;
    }
}