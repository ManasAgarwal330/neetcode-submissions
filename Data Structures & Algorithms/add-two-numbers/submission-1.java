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
    ListNode newHead = null;
    ListNode prev = null;
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       add(l1,l2);
       return newHead;
    }

    public void add(ListNode l1,ListNode l2){
       if(l1 == null && l2 == null && carry == 0)return;
       int val1 = 0;
       int val2 = 0;
       
       if(l1!=null && l2!=null){
        val1 = l1.val;
        val2 = l2.val;
       }
       else if(l2 != null){
            val2 = l2.val;
       }
       else if(l1 != null){
            val1 = l1.val;
       }
      
       int sum = val1 + val2 + carry;
       carry = sum/10;
       ListNode node = new ListNode(sum % 10);

       if(newHead == null) newHead = node;
       if(prev == null) prev = node;
       else {
        prev.next = node;
        prev = node;
       }

        if(l1!=null && l2!=null){
         add(l1.next,l2.next);
       }
       else if(l2 != null){
            add(l1,l2.next);
       }
       else if(l1 != null){
             add(l1.next,l2);
       }
      
    }
}
