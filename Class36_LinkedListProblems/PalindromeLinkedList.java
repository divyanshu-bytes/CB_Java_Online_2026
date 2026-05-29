import java.util.Scanner;

public class PalindromeLinkedList{

	public static Node createLinkedList(){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		Node head = null;
		Node temp = head;

		while(n-- > 0){
			int data = scanner.nextInt();
			if(head == null){
				head = new Node(data);
				temp = head;
			}
			else{
				temp.next = new Node(data);
				temp = temp.next;
			}
		}

		return head;
	}

	public static void printLL(Node head){
		System.out.println("Linked List Traversal: ");
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static Node midNode(Node head){
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public static Node reverseLinkedList(Node head){
		if(head == null){
			return null;
		}

		System.out.println("Reversing Linked List from node = " + head.data + " ...");
		Node prev = null;
		Node curr = head;
		Node nxt;

		while(curr != null){
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}

		return prev;
	}

	public static boolean checkPalindrome(Node head){
		Node mid = midNode(head);

		Node reverseHead = reverseLinkedList(mid);

		Node tempHead = head;
		Node tempReverseHead = reverseHead;

		while(tempHead != null && tempReverseHead != null){
			if(tempHead.data != tempReverseHead.data){
				return false;
			}
			tempHead = tempHead.next;
			tempReverseHead = tempReverseHead.next;
		}
		return true;
	}

	public static void main(String[] args){
		Node head = createLinkedList();

		printLL(head);

		if(checkPalindrome(head)){
			System.out.println("It is a Palindromic Linked List");
		}
		else{
			System.out.println("It is a Non-Palindromic Linked List");
		}
		
	}

}