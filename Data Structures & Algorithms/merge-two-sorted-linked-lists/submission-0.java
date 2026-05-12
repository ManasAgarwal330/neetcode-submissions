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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = null;
        ListNode temp = null;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                if(newHead == null){
                    newHead = list1;
                    temp = newHead;
                }else{
                    temp.next = list1;
                    temp = temp.next;
                }
                list1 = list1.next;
            }else{
                if(newHead == null){
                    newHead = list2;
                    temp = newHead;
                }else{
                    temp.next = list2;
                    temp = temp.next;
                }
                list2 = list2.next;
            }
        }

        if(list1 != null){
            if(newHead == null){
                return list1;
            }
            temp.next = list1;
        }

        if(list2 != null){
            if(newHead == null){
                return list2;
            }
            temp.next = list2;
        }

        return newHead;
    }
}