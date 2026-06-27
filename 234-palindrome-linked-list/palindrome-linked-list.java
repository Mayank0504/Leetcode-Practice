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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode curr=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        while(slow!=null){
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        ListNode slow1=prev;
        while(prev!=null){
            if(prev.val!=curr.val){
                ListNode prev1=null;
                while(slow1!=null){
                    ListNode temp=slow1.next;
                    slow1.next=prev1;
                    prev1=slow1;
                    slow1=temp;
                }
                return false;
            }
            prev=prev.next;
            curr=curr.next;
        }
        ListNode prev2=null;
        while(slow1!=null){
            ListNode temp=slow1.next;
            slow1.next=prev2;
            prev2=slow1;
            slow1=temp;
        }
        return true;
    }
}