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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode before=dummy;
        ListNode slow=head;
        ListNode fast=head;
        int i=1;
        int j=1;
        while(i<left){
            before=slow;
            slow=slow.next;
            i++;
        }
        ListNode curr=slow;
        while(j<right){
            fast=fast.next;
            j++;
        }
        ListNode prev=fast.next;
        while(i<=j){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            i++;
        }
        before.next=prev;
        return dummy.next;
    }
}