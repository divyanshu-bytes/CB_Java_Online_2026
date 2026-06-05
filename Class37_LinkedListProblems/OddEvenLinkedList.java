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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTemp = oddHead;
        ListNode evenTemp = evenHead;

        while(oddTemp != null && evenTemp != null && evenTemp.next != null){
            oddTemp.next = evenTemp.next;
            oddTemp = oddTemp.next;
            
            evenTemp.next = oddTemp.next;
            evenTemp = evenTemp.next;
        }

        if(oddHead == null){
            // there is no odd linked list => return evenHead
            return evenHead;
        }
        else{
            oddTemp.next = evenHead;
        }
        return oddHead;
    }
}