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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast=head.next;;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode slow_1=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(slow_1);
        return merge(left,right);

    }
    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(left!=null&&right!=null){
            if(left.val<=right.val){
                curr.next=left;
                left=left.next;
            }else{
                curr.next=right;
                right=right.next;
            }
            curr=curr.next;
        }
        if(left!=null){
            curr.next=left;
        }
        if(right!=null){
            curr.next=right;
        }
        return dummy.next;
    }

        // if(head==null)return null;
        // ArrayList<Integer> list=new ArrayList<>();
        // ListNode curr=head;
        // while(curr!=null){
        //     list.add(curr.val);
        //     curr=curr.next;
        // }
        // Collections.sort(list);
        // ListNode curr1=head;
        // int index=0;
        // while(curr1!=null){
        //     curr1.val=list.get(index);
        //     index++;
        //     curr1=curr1.next;
        // }
        // return head;
}