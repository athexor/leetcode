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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;

        return constructTree(inorder, preorder, 0, n-1, 0, n-1);
    }

    public TreeNode constructTree(int[] inorder, int[] preorder, int i, int j, int k, int l){
        if(i > j)
            return null;

        int rootValue = preorder[k];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = 0;
        for(int index=i; index<=j; index++){
            if(inorder[index] == rootValue){
                rootIndex = index;
                break;
            }
        }
        
        int leftSize = rootIndex - i;

        root.left = constructTree(inorder, preorder, i, rootIndex-1, k+1, k+leftSize);
        root.right = constructTree(inorder, preorder, rootIndex+1, j, k+leftSize+1, l);

        return root;
    }

}

/**
 * Time Complexity: O(N^2) worst case
 *                  - N nodes are created, but each call does a linear scan
 *                    over the inorder range to find rootIndex -> O(N) per node.
 *                  - Worst case (skewed tree): O(N) + O(N-1) + ... = O(N^2).
 *                  (Can be optimized to O(N) using a HashMap<value, index>.)
 *
 * Space Complexity: O(H), where H is the height of the tree,
 *                   due to the recursive call stack.
 *                   O(log N) for a balanced tree, O(N) worst case (skewed tree).
 */