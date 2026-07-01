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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode newhead=dummy;
        while(true){
            ListNode kth=newhead;
            for(int i=0;i<k;i++){
                kth=kth.next;
                if(kth==null){
                    return dummy.next;
                }
            }
            ListNode tail=kth.next;
            ListNode prev=newhead.next;
            ListNode curr=tail;
            while(prev!=tail){
                ListNode temp=prev.next;
                prev.next=curr;
                curr=prev;
                prev=temp;
            }
            ListNode temp=newhead.next;
            newhead.next=kth;
            newhead=temp;
        }
    }
}