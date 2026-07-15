/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         Stack<Integer> s=new Stack<>();
//         Stack<Integer> s2=new Stack<>();
//         ListNode st=l1;
//         ListNode st2=l2;
//         while(st!=null){
//             s.push(st.val);
//             st=st.next;
//         }
//         while(st2!=null){
//             s2.push(st2.val);
//             st2=st2.next;
//         }
//         int sum=0;
//         int carry=0;
//         ArrayList<Integer> ans=new ArrayList<>();
//         while(!s.isEmpty()&&!s2.isEmpty()){
//             sum=0;
//             sum=s.pop()+s2.pop();
//             if(carry>0){
//                 sum+=carry;
//             }
//             carry=0;
//             if(sum>9){
//                 sum=sum%10;
//                 carry=1;
//                 ans.add(sum);
//             }else{
//                 ans.add(sum);
//             }
//         }
//         while(!s.isEmpty()){
//             sum=0;
//             if(carry>0){
//                 sum+=carry;
//             }
//             carry=0;
//             sum+=s.pop();
//             if(sum>9){
//                 sum=sum%10;
//                 carry=1;
//                 ans.add(sum);
//             }else{
//                 ans.add(sum);
//             }
//         }while(!s2.isEmpty()){
//             sum=0;
//             if(carry>0){
//                 sum+=carry;
//             }
//             carry=0;
//             sum+=s2.pop();
//             if(sum>9){
//                 sum=sum%10;
//                 carry=1;
//                 ans.add(sum);
//             }else{
//                 ans.add(sum);
//             }
//         }
//         if(carry>0){
//             ans.add(1);
//         }
//         Collections.reverse(ans);
//         ListNode dummy=new ListNode(0);
//         ListNode curr=dummy;
//         for(int digit:ans){
//             curr.next=new ListNode(digit);
//             curr=curr.next;
//         }

        
//         return dummy.next;
//     }
// }
class Solution {
    public static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        ListNode front = null;
        while(cur != null){
            front = cur.next;
            cur.next = prev;
            prev = cur;
            cur = front;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = reverse(l1);
        ListNode temp2 = reverse(l2);
        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode dummy = dummyNode;

        while(temp1 != null || temp2 != null || carry > 0){
            int sum = carry;
           if(temp1 != null){
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if(temp2 != null){
                sum += temp2.val;
                temp2 = temp2.next;
            }
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
        }
        return reverse(dummyNode.next);
    }
}