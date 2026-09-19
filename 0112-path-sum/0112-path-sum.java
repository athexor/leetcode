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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null && root.val == targetSum){
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

/**
 * Approach: DFS (recursion) - at each node, subtract the node's value from
 * the target sum and recurse into left/right children. A path is valid if
 * we reach a leaf node where the remaining sum equals the leaf's value.
 *
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 *                  Each node is visited exactly once, doing O(1) work per node.
 *
 * Space Complexity: O(H), where H is the height of the tree, due to the
 *                   recursive call stack. O(log N) for a balanced tree,
 *                   O(N) in the worst case (skewed tree).
 */