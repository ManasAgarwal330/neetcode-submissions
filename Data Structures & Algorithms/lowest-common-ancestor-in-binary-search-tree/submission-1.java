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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);

        return lca;
    }

    public boolean lca(TreeNode root,TreeNode p,TreeNode q){
        if(root == null)return false;

        boolean left = lca(root.left,p,q);
        boolean right = lca(root.right,p,q);

        if(left && right && lca == null){
            lca = root;
        }else if((left || right) && (p.val == root.val || q.val == root.val) && lca == null){
            lca = root;
        }      

        if(root.val == p.val || root.val == q.val || left || right)return true;  

        return false;
    }

}