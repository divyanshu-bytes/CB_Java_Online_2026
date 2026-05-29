import java.util.Scanner;

public class MidNodeLinkedList{

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

	public static void main(String[] args){
		Node head = createLinkedList();

		Node mid = midNode(head);
		printLL(head);
		System.out.println("Middle Node of Linked List: " + mid.data);
	}
}