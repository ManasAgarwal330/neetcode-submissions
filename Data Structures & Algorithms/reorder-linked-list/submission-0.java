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
    ListNode prevCon = null;
    ListNode temp = null;
    boolean stop = false;
    public void reorderList(ListNode head) {
        temp = head;
        reorder(head);
    }

    public void reorder(ListNode node){
        if(node == null)return;

        reorder(node.next);
        if(stop)return;

        if(prevCon != null){
            prevCon.next = temp;
        }

        if(node == temp || temp.next == node){
            node.next= null;
            stop = true;
            return;
        }
        
        ListNode prev = temp.next;
        temp.next = node;
        temp = prev;
        prevCon = node;
        node.next= null;
    }
}
