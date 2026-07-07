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
        if(head==null)return null;
        ArrayList<Integer> list=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        Collections.sort(list);
        ListNode curr1=head;
        int index=0;
        while(curr1!=null){
            curr1.val=list.get(index);
            index++;
            curr1=curr1.next;
        }
        return head;
    }
}