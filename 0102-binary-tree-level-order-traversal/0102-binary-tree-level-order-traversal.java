/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(){}
 *     TreeNode(int val){ this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right){
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public List<List<Integer>> levelOrder(TreeNode A){
        List<List<Integer>> result = new ArrayList<>();

        if(A == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                level.add(temp.val);

                if(temp.left != null)queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
            }

            result.add(level);
        }

        return result;
    }
}

/** 
 * class Solution {
 *     public List<List<Integer>> levelOrder(TreeNode A){
 *         Queue<TreeNode> queue = new LinkedList<>();
 *         List<List<Integer>> list = new ArrayList<>();
 * 
 *         if(A == null)return list;
 * 
 *         queue.add(A);
 *         queue.add(null);
 * 
 *         list.add(new ArrayList<>()); // First level
 *         int index = 0;
 *
 *         while(!queue.isEmpty()){
 *             TreeNode temp = queue.remove();
 *             if(temp == null){
 *                 if(!queue.isEmpty()){ // Only add another marker if nodes remain
 *                     queue.add(null);
 *                     index++;
 *                     list.add(new ArrayList<>()); // Create list for next level
 *                 }
 *             } else {
 *                 list.get(index).add(temp.val);
 *                 if(temp.left != null)queue.add(temp.left);
 *                 if(temp.right != null)queue.add(temp.right);
 *             }
 *         }
 
 *         return list;
 *     }
 * }
 */