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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();

        while(l1!=null){
            list1.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            list2.add(l2.val);
            l2=l2.next;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;int j=0; int carry=0;int sum=0;
        while(i<list1.size()||j<list2.size()||carry!=0){
            sum=0;
            if(i<list1.size()){
                sum+=list1.get(i);
            }
            if(j<list2.size()){
                sum+=list2.get(j);
            }
            if(carry>0){
                sum+=carry;
                carry=0;
            }
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
                ans.add(sum);
            }else{
                ans.add(sum);
            }
            i++;
            j++;
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        for(int digit:ans){
            curr.next=new ListNode(digit);
            curr=curr.next;
        } 
        return dummy.next;
    }
}