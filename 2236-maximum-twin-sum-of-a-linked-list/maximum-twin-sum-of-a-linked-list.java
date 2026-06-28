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
class Solution {
    public int pairSum(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int maxi1=0;
        int maxi=0;
        ListNode st=head; 
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null){
            fast=fast.next.next;
            slow=slow.next;
            dummy=dummy.next;
        }
        dummy=dummy.next;
        ListNode prev=null;
        while(slow!=null){
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        while(prev!=null){
            maxi=0;
            maxi=st.val+prev.val;
            st=st.next;
            prev=prev.next;
            maxi1=Math.max(maxi1,maxi);
        }
        return maxi1;
    }
}