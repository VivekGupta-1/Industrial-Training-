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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode ist = head;
        for (int i = 1; i < k; i++){
            ist = ist.next;
        }
        ListNode second = head;
        ListNode temp = ist;
        while (temp.next != null){
            temp = temp.next;
            second = second.next;
        }
        int val = ist.val;
        ist.val = second.val;
        second.val = val;

        return head;
    }
}