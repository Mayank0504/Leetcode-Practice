/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
//     }
//     int count=0;
//     int temp=0;
//     public List<Integer> find(TreeNode root, TreeNode target, int k) {
//         if(root==null){
//             return null;
//         }
//         if(root.left==null&&root.right){
//             if(count>0){
//                 count=count-1;
//             }
//         }
//         if(root.val==target){
//             temp=count;
//         }
//         count++;
//         find(root.left,target,k);
//         find(root.right,target,k);
//         return temp;
//     }
// }
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, target, k);
        return ans;
    }
    int dfs(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return -1;
        if (root == target) {
            findDown(root, k);
            return 0;
        }
        int left = dfs(root.left, target, k);
        if (left != -1) {
            if (left + 1 == k) {
                ans.add(root.val);
            }
            findDown(root.right, k - left - 2);
            return left + 1;
        }
        int right = dfs(root.right, target, k);
        if (right != -1) {
            if (right + 1 == k) {
                ans.add(root.val);
            }
            findDown(root.left, k - right - 2);
            return right + 1;
        }
        return -1;
    }
    void findDown(TreeNode root, int k) {
        if (root == null || k < 0)
            return;
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        findDown(root.left, k - 1);
        findDown(root.right, k - 1);
    }
}