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
    public ListNode rotateRight(ListNode head, int k) {
    // if(head == null || head.next == null)return head;
    //     int i=0;
    //     while(i<k){
    //         ListNode first=head;
    //         ListNode second=null;
    //         while(first.next!=null){
    //             if(first.next.next==null){
    //                 second=first;
    //             }
    //             first=first.next;
    //         }
    //         first.next=head;
    //         second.next=null;
    //         head=first;

    //         i++;
    //     }
    //     return head;
        if(head == null || head.next == null)return head;
        int len=1;
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
            len++;
        }
        k=k%len;
        if(k==0){
            return head;
        }
        curr.next=head;
        int step=len-k;
        ListNode newhead=head;
        for(int i=1;i<step;i++){
            newhead=newhead.next;
        }
        ListNode newtail=newhead.next;
        newhead.next=null;
        return newtail;

    }
}