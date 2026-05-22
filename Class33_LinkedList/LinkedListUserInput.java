import java.util.Scanner;

public class LinkedListUserInput{

	public static class LinkedListNode{
		public int data;
		public LinkedListNode next;

		// Constructor
		public LinkedListNode(int data){
			this.data = data;
			this.next = null;
		}
	}

	public static void traverseLinkedList(LinkedListNode head){
		LinkedListNode temp = head;			// temp => alias or nickname
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
		return;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();		// e.g, n = 5
		
		int data = scanner.nextInt();
		LinkedListNode head = new LinkedListNode(data);
		LinkedListNode temp = head;

		for(int i=1; i<n; i++){
			data = scanner.nextInt();
			LinkedListNode newNode = new LinkedListNode(data);
			temp.next = newNode;
			temp = temp.next;
		}

		traverseLinkedList(head);
	}
}