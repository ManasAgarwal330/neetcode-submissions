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
    ListNode temp = null;
    ListNode afterRev = null;
    ListNode p = null;
    ListNode phead = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        temp = head;
        int count = 1;
        ListNode prev = null;
        while(count < left){
            if(count+1 == left)prev = temp;
            temp = temp.next;
            count++;
        }
        
        reverseList(temp,right-left+1);
        p.next = afterRev;
        if(prev != null)
        {
            prev.next = phead;
        }else{
            return phead;
        }
        return head;
    }

    public void reverseList(ListNode node,int count){
        if(count == 0)return;

        reverseList(node.next,count-1);
        if(p == null)afterRev = node.next;
        node.next = null;

        if(p == null){
            p = node;
            phead = node;
        }
        else{
            p.next = node;
            p = p.next;
        }
    }
}