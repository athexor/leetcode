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
    public List<Integer> preorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        traverse(A, list);
        return list;
    }

    public void traverse(TreeNode A, List list){
        if(A == null){
            return;
        }
        list.add(A.val);
        traverse(A.left, list);
        traverse(A.right, list);
    }
}