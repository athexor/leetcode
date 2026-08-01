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
    public int findBottomLeftValue(TreeNode A) {
        if(A == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(A);
        int leftElement = A.val;
        
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<=n-1; i++){
                TreeNode temp = queue.remove();
                if(i == 0)  leftElement = temp.val;
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }

        return leftElement;
    }
}