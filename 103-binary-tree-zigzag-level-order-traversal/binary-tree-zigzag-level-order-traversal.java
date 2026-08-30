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
// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         int tra=1;
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         List<List<Integer>> ans= new LinkedList<List<Integer>>();
//         if(root==null)return ans;
//         queue.offer(root);
//         tra++;
//         while(!queue.isEmpty()){
//             if(tra%2==0){
//                 int size=queue.size();
//                 List<Integer> l=new ArrayList<>();
//                 for(int i=0;i<size;i++){
//                     if(queue.peek()!=null)queue.offer(queue.peek().right);
//                     if(queue.peek()!=null)queue.offer(queue.peek().left);
//                     l.add(queue.poll().val);
//                 }
//                 ans.add(l);
//             }
//             else{
//                 int size=queue.size();
//                 List<Integer> l=new ArrayList<>();
//                 for(int i=0;i<size;i++){
//                     if(queue.peek()!=null)queue.offer(queue.peek().left);
//                     if(queue.peek()!=null)queue.offer(queue.peek().right);
//                     l.add(queue.poll().val);
//                 }
//                 ans.add(l);
//             }
//             tra++;
//         }
//         return ans;
//     }
// }
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        int tra = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> l = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();

                l.add(curr.val);

                // Queue me hamesha LEFT -> RIGHT
                if (curr.left != null)
                    queue.offer(curr.left);

                if (curr.right != null)
                    queue.offer(curr.right);
            }

            // Even level -> Right to Left
            if (tra % 2 == 0) {
                Collections.reverse(l);
            }

            ans.add(l);
            tra++;
        }

        return ans;
    }
}