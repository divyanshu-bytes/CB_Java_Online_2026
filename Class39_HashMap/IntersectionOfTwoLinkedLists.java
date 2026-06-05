/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public int lengthOfLL(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = lengthOfLL(headA);
        int lenB = lengthOfLL(headB);
        ListNode tempA = headA;
        ListNode tempB = headB;

        if(lenA > lenB){
            int diff = lenA - lenB;
            while(diff-- > 0){
                tempA = tempA.next;
            }
        }
        else{
            int diff = lenB - lenA;
            while(diff-- > 0){
                tempB = tempB.next;
            }
        }

        while(tempA != null && tempB != null){
            if(tempA == tempB)
                return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }
}