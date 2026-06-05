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
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        int carry = 0;
        while(temp1 != null || temp2 != null || carry > 0){
            int temp1Contribution = 0;
            if(temp1 != null){
                temp1Contribution = temp1.val;
                temp1 = temp1.next;
            }
            int temp2Contribution = 0;
            if(temp2 != null){
                temp2Contribution = temp2.val;
                temp2 = temp2.next;
            }
            int sum = temp1Contribution + temp2Contribution + carry;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;
        }

        return dummyHead.next;
    }
}