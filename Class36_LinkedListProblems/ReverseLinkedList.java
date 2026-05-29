import java.util.Scanner;

public class ReverseLinkedList{

	public static class LLNode{
		public int data;
		public LLNode next;

		public LLNode(int data){
			this.data = data;
			this.next = null;
		}
	}

	public static void printLL(LLNode head){
		System.out.println("Linked List Traversal: ");
		LLNode temp = head;
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static LLNode reverseLinkedList(LLNode head){
		System.out.println("Reversing Linked List...");
		LLNode prev = null;
		LLNode curr = head;
		LLNode nxt;

		while(curr != null){
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}

		return prev;
	}

	public static LLNode reverseLinkedListRecursive(LLNode head){
		if(head == null || head.next == null){
			return head;
		}

		LLNode newHead = reverseLinkedListRecursive(head.next);		// recursive call

		head.next.next = head;	// self work
		head.next = null;		// self work

		return newHead;
	}

	public static void main(String[] args){
		LLNode head = null;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = scanner.nextInt();		// n = 5 nodes

		System.out.println("Enter nodes of Linked List: ");
		LLNode temp = head;
		while(n-- > 0){
			int data = scanner.nextInt();
			if(head == null){
				head = new LLNode(data);
				temp = head;
			}
			else{
				temp.next = new LLNode(data);
				temp = temp.next;
			}
		}

		printLL(head);
		
		head = reverseLinkedList(head);
		printLL(head);

		head = reverseLinkedList(head);
		printLL(head);

		head = reverseLinkedList(head);
		printLL(head);

		return;
	}

}