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
        if(head==null) return null;
        insertCopyBetween(head);
        connectRandom(head);
        return getCopyList(head);
    }
    void insertCopyBetween(Node head){
        Node temp = head;
        while(temp!=null){
            Node newElement = temp.next;
            Node copy = new Node(temp.val);
            copy.next = newElement;
            temp.next = copy;
            temp = newElement;
        }
    }
    void connectRandom(Node head){
        Node temp = head;
        while(temp!=null){
            Node copy = temp.next;
            if(temp.random!=null){
                copy.random = temp.random.next;
            }else{
                copy.random = null;
            }
            temp = temp.next.next;
        }
    }
    Node getCopyList(Node head){
        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while(temp!=null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }
    
}