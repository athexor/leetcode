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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        return constructTree(inorder, postorder, 0, n-1, 0, n-1);
    }

    public TreeNode constructTree(int[] inorder, int[] postorder, int i, int j, int k, int l){
        if(i > j)
            return null;

        int rootValue = postorder[l];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = 0;
        for(int index=0; index<=j; index++){
            if(inorder[index] == rootValue)
                rootIndex = index;
        }
        
        int leftSize = rootIndex - i;

        root.left = constructTree(inorder, postorder, i, rootIndex-1, k, (k+leftSize-1));
        root.right = constructTree(inorder, postorder, rootIndex+1, j, k+leftSize, l-1);

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