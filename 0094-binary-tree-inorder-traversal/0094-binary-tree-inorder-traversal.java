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
    public List<Integer> inorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = A;
        
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
                    list.add(curr.val);
                    temp.right = null;
                    curr = curr.right;
                }
            }else{
                list.add(curr.val);
                curr = curr.right;
            }
        }

        return list;
    }
}

/**
 *
 * No need to check if the tree is null separately.
 * if(A == null)
 *     return new ArrayList<>();
 *
 * The while(curr != null) condition already handles it.
 * If A is null:
 *     curr = null
 *     while condition becomes false
 *     loop will not execute.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */