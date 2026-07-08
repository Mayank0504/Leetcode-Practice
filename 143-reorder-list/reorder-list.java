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
    public void reorderList(ListNode head) {
            if(head.next==null||head.next.next==null){
                return;
            }
            ListNode fast=head;
            ListNode slow=head;
            while(fast.next!=null&&fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode newhead=slow.next;
            slow.next=null;
            ListNode prev=null;
            while(newhead!=null){
                ListNode temp=newhead.next;
                newhead.next=prev;
                prev=newhead;
                newhead=temp;
            }
            ListNode realhead=head;
            newhead=prev;
            while(newhead!=null){
                ListNode temp1=realhead.next;
                ListNode temp2=newhead.next;
                realhead.next=newhead;
                newhead.next=temp1;
                realhead=temp1;
                newhead=temp2;
            } 

    //     if(head==null)return;
    //     ArrayList<ListNode> list=new ArrayList<>();
    //     ListNode curr=head;
    //     while(curr!=null){
    //         list.add(curr);
    //         curr=curr.next;
    //     }
    //     int left=0;
    //     int right=list.size()-1;
    //     while(left<right){
    //         list.get(left).next=list.get(right);
    //         left++;
    //         if(left==right){
    //             break;
    //         }
    //         list.get(right).next=list.get(left);
    //         right--;
    //     }
    //     list.get(left).next=null;
    // }

    // public ListNode reorderList_1(ListNode head) {
    //     ListNode curr=head;
    //     ListNode curr_1=head;
    //     if(curr.next==null){
    //         return curr;
    //     } 
    //     reorderList_1(curr.next);
        
    }
}