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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int count = 0;

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
                    count++;
                    if(count == k)
                        return curr.val;
                    curr = curr.right;
                }

            }else{
                count++;
                if(count == k)
                    return curr.val;
                curr = curr.right;
            }
        }

        return -1;
    }
}

/**
 * Approach: Morris Inorder Traversal (Threaded Binary Tree) on BST.
 *
 * We don't need to explicitly handle the A == null case since the
 * while(curr != null) loop already handles it naturally. Also,
 * constraints mention minimum 1 node, so tree won't be empty anyway.
 *
 * Since a BST's inorder traversal visits nodes in sorted order, we
 * count nodes as we visit them via Morris traversal and return as
 * soon as the count hits B - no need to build the full sorted list,
 * no stack, no recursion.
 *
 * Time Complexity: O(N) worst case --
 *                   each edge is traversed at most twice (thread
 *                   creation and removal), but we return early the
 *                   moment count == B, so in practice we often stop
 *                   well before touching every node.
 *
 * Space Complexity: O(1) --
 *                   no recursion stack or explicit stack is used;
 *                   only a constant number of pointers (curr, temp)
 *                   and a counter.
 */