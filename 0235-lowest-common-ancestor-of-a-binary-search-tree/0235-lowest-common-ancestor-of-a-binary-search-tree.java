/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;

        while(temp != null){
            if(p.val < temp.val && q.val < temp.val){
                temp = temp.left;
            }else if(p.val > temp.val && q.val > temp.val){
                temp = temp.right;
            }else{
                return temp;
            }
        }

        return null;
    }
}

/**
 * Approach: Iterative BST Property based LCA (single while loop).
 *
 * We don't need to explicitly handle the A == null case since the
 * while(temp != null) loop already handles it naturally. Also,
 * constraints mention minimum 1 node, so tree won't be empty anyway.
 * Since p and q are guaranteed to exist in the tree, the loop will
 * always find the LCA and return from inside it. The final return null
 * is only there to satisfy the compiler and is never reached.
 *
 * We are using a direct while loop instead of recursion to reduce the
 * space. Recursion would keep every call on the call stack (O(H) space,
 * and a risk of stack overflow on a skewed tree), whereas the loop just
 * moves a single pointer (temp) down the tree, so the space becomes O(1).
 * *
 * Time Complexity: O(H) --
 *                   we walk down a single root-to-node path and never
 *                   visit more than one node per level, where H is the
 *                   height of the tree. O(log N) for a balanced tree,
 *                   O(N) worst case (skewed tree).
 *
 * Space Complexity: O(1) --
 *                   purely iterative, no recursion stack or extra data
 *                   structures; only one pointer (temp) is used.
 */