/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        Node left = head, right = head;
        while(right.next != null){
            right = right.next;
        }
        
        // left => head
        // right => tail
        
        while(left != right && right.next != left){
            if(left.data + right.data == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                ans.add(pair);
                left = left.next;
                right = right.prev;
            }
            else if(left.data + right.data < target){
                left = left.next;
            }
            else{
                // left.data + right.data < target
                right = right.prev;
            }
        }
        return ans;
    }
}
