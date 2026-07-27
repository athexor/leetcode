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
    public List<List<Integer>> levelOrder(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if (A == null) return list;

        queue.add(A);
        queue.add(null);

        list.add(new ArrayList<>()); // First level

        int index = 0;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();

            if (temp == null) {
                if (!queue.isEmpty()) { // Only add another marker if nodes remain
                    queue.add(null);
                    index++;
                    list.add(new ArrayList<>()); // Create list for next level
                }
            } else {
                list.get(index).add(temp.val);

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }

        return list;
    }
}