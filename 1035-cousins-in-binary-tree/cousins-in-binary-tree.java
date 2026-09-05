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
    int xlevel=-1;
    int ylevel=-1;
    TreeNode xparent=null;
    TreeNode yparent=null;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;
        cousin(root,0,null,x,y);
        if(xlevel==ylevel&&xparent!=yparent){
            return true;
        }
        return false;
    }
    public void cousin(TreeNode root,int level,TreeNode parent,int x,int y){
        if(root==null){
            return;
        }
        if(root.val==x){
            xlevel=level;
            xparent=parent;
            
        }
        if(root.val==y){
            ylevel=level;
            yparent=parent;
        }
        cousin(root.left,level+1,root,x,y);
        cousin(root.right,level+1,root,x,y);
    }
}