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

    ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, nxt = null;
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public ListNode plusOne(ListNode head) {
        head = reverse(head);

        int carry = 1;
        ListNode temp = head;
        ListNode prev = null;

        while(temp != null || carry > 0){
            int val = carry;
            if(temp != null){
                val += temp.val;
                temp.val = val % 10;
            }
            else{
                prev.next = new ListNode(val % 10);
                temp = prev.next;
            }
            carry = val / 10;
            prev = temp;
            temp = temp.next;
        }

        head = reverse(head);
        return head;
    }
}