import java.util.Scanner;

public class StartingNodeOfCycleLinkedList{
	
	public static Node createLinkedList(){
		Node head = null;
		Node tail = head;

		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();

		while(data != -1){
			Node newNode = new Node(data);
			if(tail == null){
				// head -> null -> empty linked list
				head = tail = newNode;
			}
			else{
				tail.next = newNode;
				tail = tail.next;
			}
			data = scanner.nextInt();
		}
		return head;
	}

	public static void printLinkedList(Node head){
		System.out.println("Printing Linked List...");
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
		return;
	}

	public static Node createLinkedListWithCycle(){
		Node head = null;
		Node tail = head;

		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();

		while(data != -1){
			Node newNode = new Node(data);
			if(tail == null){
				// head -> null -> empty linked list
				head = tail = newNode;
			}
			else{
				tail.next = newNode;
				tail = tail.next;
			}
			data = scanner.nextInt();
		}

		printLinkedList(head);
		System.out.println("Generating Cycle in Linked List...");

		if(tail != null && head.next != null){
			tail.next = head.next;
		}
		return head;
	}	

	public static boolean detectCycle(Node head){
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}

	public static Node detectCycleAndReturnStartingNode(Node head){
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}

		if(fast == null || fast.next == null){
			return null;
		}

		slow = head;

		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String... args){
		Node head = createLinkedListWithCycle();
		Node startNodeOfCycle = detectCycleAndReturnStartingNode(head);
		if(startNodeOfCycle != null){
			System.out.println("Cycle is found at Node = " + startNodeOfCycle.data);
		}
		else{
			System.out.println("No Cycle is found");
		}

		head = createLinkedList();
		startNodeOfCycle = detectCycleAndReturnStartingNode(head);
		if(startNodeOfCycle != null){
			System.out.println("Cycle is found at Node = " + startNodeOfCycle.data);
		}
		else{
			System.out.println("No Cycle is found");
		}
	}
}