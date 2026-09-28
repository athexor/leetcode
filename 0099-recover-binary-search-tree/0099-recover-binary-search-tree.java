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
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode secound = null;

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
                    temp.right = null;
                    if(prev != null && prev.val > curr.val){
                        if(first == null)
                            first = prev;
                        secound = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }else{
                if(prev != null && prev.val > curr.val){
                    if(first == null)
                        first = prev;
                    secound = curr;
                }
                prev = curr;
                curr = curr.right;
            }
        }

        int temp = first.val;
        first.val = secound.val;
        secound.val = temp;
    }
}

/**
 * Approach: Morris Inorder Traversal (Threaded Binary Tree).
 *
 * We don't need to explicitly handle the A == null case since the
 * while(curr != null) loop already handles it naturally. Also,
 * constraints mention minimum 2 node, and it's guaranteed that 
 * exactly two nodes are swapped, so no null check is needed.  *
 *
 * Time Complexity: O(N) --
 *                   each edge is traversed at most twice (once to create
 *                   the thread, once to remove it), so total work is linear.
 *                   The thread is always removed before moving on, so the
 *                   tree is fully restored at the end.
 *
 * Space Complexity: O(1) --
 *                   no recursion stack or explicit stack; only a constant
 *                   number of pointers (curr, temp, prev, first, second).
 *                   This meets the problem's constant space requirement.
 */