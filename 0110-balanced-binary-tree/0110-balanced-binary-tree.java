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
    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return balanced;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return -1;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

/**
 * Approach: Optimized single-pass DFS.
 * Compute the height of every subtree bottom-up. While computing height,
 * simultaneously check the balance condition (|leftHeight - rightHeight| <= 1)
 * at every node. If any node violates it, set a flag - no separate traversal
 * is needed to check balance, it's folded into the same recursion that
 * computes height.
 *
 * Time Complexity: O(N)
 *                  - Each node is visited exactly once by getHeight.
 *                  - No repeated height recomputation (unlike the brute-force
 *                    approach below).
 *
 * Space Complexity: O(H), where H is the height of the tree,
 *                   due to the recursive call stack.
 *                   O(log N) for a balanced tree, O(N) worst case (skewed tree).
 */