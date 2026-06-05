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

    public int lengthOfLL(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    ListNode reverseKGroupRec(ListNode head, int k, int lenOfLL){
        if(lenOfLL < k){
            return head;
        }

        // Step-1
        ListNode prev = null, curr = head, nxt = null;
        for(int i=0; i<k; i++){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        // reverseHead => prev
        // Step-2
        ListNode nextKReverseHead = reverseKGroupRec(curr, k, lenOfLL - k);
        // Step-3
        head.next = nextKReverseHead;
        // Step-4
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int lenOfLL = lengthOfLL(head);
        ListNode kReverseHead = reverseKGroupRec(head, k, lenOfLL);
        return kReverseHead;
    }
}