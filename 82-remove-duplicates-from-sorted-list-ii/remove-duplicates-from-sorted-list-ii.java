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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        if(head.next==null)return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode first=dummy;
        ListNode curr=head;
        while(curr!=null&&curr.next!=null){
            if(curr.val==curr.next.val){
                while(curr.val==curr.next.val){
                    curr=curr.next;
                    if(curr.next==null)break;
                }
                first.next=curr.next;
                curr=curr.next;
            }
            else{
                curr = curr.next;
                first=first.next;
            }
        }
        return dummy.next;
    }
}