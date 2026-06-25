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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        curr=head;
        if(count == n){
            return head.next;
        }
        int turn=count-n;
        int i=1;
        while(i<turn){
            curr=curr.next;
            i++;
        }
        curr.next=curr.next.next;
        return head;
    }
}