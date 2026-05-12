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
    public ListNode reverseList(ListNode head) {
        reverse(null,head);

        return newHead;
    }

    public void reverse(ListNode prev,ListNode node){
        if(node == null)return;

        newHead = node;
        reverse(node , node.next);
        node.next = prev;

    }
}
