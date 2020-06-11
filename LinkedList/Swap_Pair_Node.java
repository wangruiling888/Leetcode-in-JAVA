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
