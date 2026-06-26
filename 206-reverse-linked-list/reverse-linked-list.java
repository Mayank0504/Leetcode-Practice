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
    public ListNode reverseList(ListNode head) {
        return reverse(head);

    }     
    public ListNode reverse(ListNode curr){
        if(curr==null||curr.next==null){
            return curr;
        }
        ListNode newhead=reverse(curr.next);
        curr.next.next=curr;
        curr.next=null;
        return newhead;
    }  
}