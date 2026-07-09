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
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode small1=small;
        ListNode large=new ListNode(0);
        ListNode large1=large;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=null;
            if(curr.val<x){
                small1.next=curr;
                small1=small1.next;
            }
            else{
                large1.next=curr;
                large1=large1.next;
            }
            curr=temp;
        }
        small1.next=large.next;
        return small.next;
    }
}