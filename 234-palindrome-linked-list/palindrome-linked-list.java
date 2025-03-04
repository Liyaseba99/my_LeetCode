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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null ){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newhead = reverseList(slow.next);

        ListNode first = head, second = newhead;
        

        while(second!=null){
            if(first.val!=second.val){
                reverseList(newhead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(newhead);
        return true;
    }
    public ListNode reverseList(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
           prev = temp;
            temp = front;
        }
        return prev;
    }
}