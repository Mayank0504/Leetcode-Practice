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
    TreeNode ans=null;
    int p(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return 0;
        int left=p(root.left,p,q);
        int right=p(root.right,p,q);
        int self=0;
        if(root==p||root==q){
            self=1;
        }
        int total=left+self+right;
        if(total==2&&ans==null){
            ans=root;
        }
        return total;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        p(root,p,q);
        return ans;
    }
}