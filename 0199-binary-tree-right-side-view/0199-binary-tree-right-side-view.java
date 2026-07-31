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
    public List<Integer> rightSideView(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        
        if(A == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(A);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<=n-1; i++){
                TreeNode temp = queue.remove();
                
                if(temp.left  != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);

                if(i == n-1)
                    list.add(temp.val);
            }
        }

        return list;
    }
}