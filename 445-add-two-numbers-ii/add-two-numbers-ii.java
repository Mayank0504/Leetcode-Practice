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
        Stack<Integer> s=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        ListNode st=l1;
        ListNode st2=l2;
        while(st!=null){
            s.push(st.val);
            st=st.next;
        }
        while(st2!=null){
            s2.push(st2.val);
            st2=st2.next;
        }
        int sum=0;
        int carry=0;
        ArrayList<Integer> ans=new ArrayList<>();
        while(!s.isEmpty()&&!s2.isEmpty()){
            sum=0;
            sum=s.pop()+s2.pop();
            if(carry>0){
                sum+=carry;
            }
            carry=0;
            if(sum>9){
                sum=sum%10;
                carry=1;
                ans.add(sum);
            }else{
                ans.add(sum);
            }
        }
        while(!s.isEmpty()){
            sum=0;
            if(carry>0){
                sum+=carry;
            }
            carry=0;
            sum+=s.pop();
            if(sum>9){
                sum=sum%10;
                carry=1;
                ans.add(sum);
            }else{
                ans.add(sum);
            }
        }while(!s2.isEmpty()){
            sum=0;
            if(carry>0){
                sum+=carry;
            }
            carry=0;
            sum+=s2.pop();
            if(sum>9){
                sum=sum%10;
                carry=1;
                ans.add(sum);
            }else{
                ans.add(sum);
            }
        }
        if(carry==1){
            ans.add(1);
        }
        Collections.reverse(ans);
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        for(int digit:ans){
            curr.next=new ListNode(digit);
            curr=curr.next;
        }

        
        return dummy.next;
    }
}