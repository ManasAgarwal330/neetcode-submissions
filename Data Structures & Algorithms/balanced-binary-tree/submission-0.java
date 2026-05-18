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
    boolean isbalanced = true;
    public boolean isBalanced(TreeNode root) {
        balanced(root);
        return isbalanced;
    }

    public int balanced(TreeNode root){
        if(root == null)return 0;

        int left = balanced(root.left);
        int right = balanced(root.right);

        if(Math.abs(left-right) > 1){
            isbalanced = false;
        }

        return Math.max(left,right)+1;
    }
}
