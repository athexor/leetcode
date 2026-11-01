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
    private boolean found = false;

    public boolean checkEqualTree(TreeNode root) {
        int totalSum = getTotalSum(root);    
        if(totalSum % 2 != 0)
            return false;

        solve(root, totalSum, true);

        return found;
    }

    private int getTotalSum(TreeNode root){
        if(root == null)
            return 0;

        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }

    private int solve(TreeNode root, int totalSum, boolean isRoot){
        if(root == null)
            return 0;
        
        int leftSum = solve(root.left, totalSum, false);
        int rightSum = solve(root.right, totalSum, false);
        int sum = root.val + leftSum + rightSum;
        if(!isRoot && sum == totalSum/2)
            found = true;

        return sum;
    }
    
}