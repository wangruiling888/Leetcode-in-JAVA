// Given a linked list, swap every two adjacent nodes and return its head.
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
// when modify the node's value is allowed:
// using simply node value exchange can solve the problem
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode result = head;
        while (head.next != null){
            ListNode first = head;
            ListNode second = head.next;
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
            if (head.next.next == null) break;
            else head = head.next.next;
        }
        return result;
    }
}
// when the node value is not allowed to change
// we need to change the position of nodes using 3 pointers
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head.next;
        ListNode t1 = null, t2 = null;
        // swap following element
        while (cur.next != null && cur.next.next != null){
            t1 = cur.next;
            t2 = cur.next.next;
            cur.next = t2;
            t1.next = t2.next;
            t2.next = t1;
            cur = t1;  
        }
        // swap first and second element
        t1 = head;
        t2 = head.next;
        t1.next = t2.next;
        t2.next = t1;
        return t2;
    }
}
