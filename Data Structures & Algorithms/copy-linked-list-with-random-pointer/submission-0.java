/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node tempNewList = null;
        Node newHead = null;
        HashMap<Node,Node> map = new HashMap<>();
        while(temp != null){
            if(newHead == null){
                newHead = new Node(temp.val);
                newHead.next = temp.next;
                tempNewList = newHead;
            }else{
                Node n  = new Node(temp.val);
                n.next= temp.next;
                tempNewList.next = n ;
                tempNewList = tempNewList.next;
            }
            map.put(temp,tempNewList);
            temp = temp.next;
        }

        temp = head;
        tempNewList = newHead;
        while(temp != null){
            tempNewList.random = map.get(temp.random);
            temp = temp.next;
            tempNewList = tempNewList.next;
        }

        return newHead;
    }
}
