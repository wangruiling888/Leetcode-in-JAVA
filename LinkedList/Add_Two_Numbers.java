// You are given two non-empty linked lists representing two non-negative integers. 
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
// method 1: easy to understand but cost much computation
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
