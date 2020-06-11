//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//k is a positive integer and is less than or equal to the length of the linked list. 
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
// note that value of node itself can not be changed but node itself can be moved
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode temp = head;
        for (int i = 0; i < k-1; i++){
            temp = temp.next;
            if (temp == null) return head;
        }
        int count = 0;
        ListNode cur = temp;
        while(true){
            // get sub linked list for length = k
            if (cur.next != null){
                cur = cur.next;
                count ++;
            }
            else { // if length of linked list < k, don't need to reverse
                if (count < k){
                    break;
                } 
            }
            if (count == k){
                System.out.println("-------------");
                // get the sub linked list and reverse it
                ListNode follow = cur.next;
                cur.next = null;
                // head of sub linked list is temp.next
                ListNode reversed_sub = reverse(temp.next, cur, k);
                ListNode tail = getTail(reversed_sub);
                temp.next = reversed_sub;
                tail.next = follow;
                temp = tail;
                cur = temp;
                count = 0;  
            }
        }
        temp = head;
        for (int i = 0; i < k-1; i++){
            temp = temp.next;
        }
        ListNode follow = temp.next;
        temp.next = null;
        ListNode reverse_head = reverse(head, temp, k);
        ListNode tail = getTail(reverse_head);
        tail.next = follow;
        return reverse_head;
    }
    public static ListNode reverse(ListNode head, ListNode tail,  int k){
        ListNode new_head = head;
        for (int i = 0; i < k-1; i++){
            new_head = head.next;
            head.next = null;
            head.next = tail.next;
            tail.next = head;
            head = new_head;  
        }
        return tail;
    }
    public static ListNode getTail(ListNode head){
        ListNode result = head;
        while (result.next != null) result = result.next;
        return result;
    }
    
}
