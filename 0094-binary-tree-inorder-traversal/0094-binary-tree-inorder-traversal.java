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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> list = new ArrayList<>();

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
 * Approach: Morris Inorder Traversal (Threaded Binary Tree).
 *
 * We don't need to explicitly handle the A == null case since the
 * while(curr != null) loop already handles it naturally (loop just
 * won't execute, returns empty array). Also, constraints often
 * mention minimum 1 node, so tree won't be empty anyway.
 *
 * Time Complexity: O(N) --
 *                   each edge in the tree is traversed at most twice
 *                   (once to create the thread, once to remove it),
 *                   so the total work across all nodes is linear.
 *
 * Space Complexity: O(1) --
 *                   no recursion stack or explicit stack is used;
 *                   only a constant number of pointers (curr, temp)
 *                   and the output list, which doesn't count as extra
 *                   space since it's the required output.
 */