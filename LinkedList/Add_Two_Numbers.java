// You are given two non-empty linked lists representing two non-negative integers. 
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
// method 1: easy to understand but cost much computation
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        int carry = 0;
        while ( node1.next!= null && node2.next != null){
            node1.val = node1.val + node2.val;
            node1 = node1.next;
            node2 = node2.next;
        }
        node1.val = node1.val + node2.val;
        if (node1.next == null) node1.next = node2.next;
        node1 = l1;
        while (node1.next != null){
            node1.val = node1.val + carry;
            if (node1.val >= 10){
                node1.val = node1.val - 10;
                carry = 1;
            }
            else carry = 0;
            node1 = node1.next;
        }
        node1.val = node1.val + carry;
        if (node1.val >=10){
            node1.val = node1.val - 10;
            node1.next = new ListNode(1);
        }
        return l1;
    }
}

// method 2: combine all iteration into one

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode prev = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                int sum = l1.val + l2.val + carry;
                l1.val = sum % 10;
                carry = sum /10;
                prev = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 == null){
                int sum = l2.val + carry;
                l2.val = sum % 10;
                prev.next = l2;
                carry = sum / 10;
                prev = prev.next;
                l2 = l2.next;  
            }
            else{
                int sum = l1.val + carry;
                l1.val = sum %10;
                carry = sum/10;
                prev = l1;
                l1 = l1.next;
            }
        }
        if (carry == 1){
            prev.next = new ListNode(1);
            prev = prev.next;
        }
        return head;
    }
}
