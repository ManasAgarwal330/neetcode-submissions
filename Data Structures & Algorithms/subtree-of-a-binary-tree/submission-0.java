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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)return false;

        boolean left = isSubtree(root.left,subRoot);
        boolean right = isSubtree(root.right,subRoot);

        if(left || right)return true;

        if(root.val == subRoot.val){
            boolean start = startChecking(root,subRoot);
            return start;
        }

        return false;
    }

    public boolean startChecking(TreeNode p,TreeNode q){
        if(p == null && q== null)return true;
        else if((p == null && q != null) || (p != null && q == null))return false;

        boolean left = startChecking(p.left,q.left);
        boolean right = startChecking(p.right,q.right);

        if(!right || !left){
            return false;
        }

        if(p.val != q.val)return false;
        
        return true;
    }

}
