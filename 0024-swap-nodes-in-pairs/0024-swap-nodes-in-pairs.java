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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode prev = temp;

        while (prev.next != null && prev.next.next != null) {
            ListNode Ist = prev.next;
            ListNode second = Ist.next;

            Ist.next = second.next;
            second.next = Ist;
            prev.next = second;
            prev = Ist;
        }

        return temp.next;
    }
}