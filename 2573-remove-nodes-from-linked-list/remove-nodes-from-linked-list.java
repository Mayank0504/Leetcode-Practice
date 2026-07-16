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
    public ListNode removeNodes(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head=prev;
        ListNode curr1=head;
        int max=prev.val;
        while(prev!=null&&prev.next!=null){
            if(prev.next.val<max){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
                max=prev.val;
            }
        }
        curr1=null;
        curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=curr1;
            curr1=curr;
            curr=temp;
        }
        return curr1;
    }
}


