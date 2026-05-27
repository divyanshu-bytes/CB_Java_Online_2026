// import ./LinkedList;
import java.util.Scanner;

public class LinkedListDemo{
	public static void main(String[] args){
		LinkedList ll  = new LinkedList();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Input no of nodes: ");
		int n = scanner.nextInt();		// n -> no of nodes in linked list

		int i=0; 
		while(i < n){
			System.out.println("Input the node: ");
			int data = scanner.nextInt();
			ll.insertAtHead(data);
			i++;
		}

		ll.print();
		System.out.println();

		System.out.println("Input the node: ");
		int data = scanner.nextInt();
		System.out.println("Input the idx: ");
		int idx = scanner.nextInt();
		ll.insertAtIndex(data, idx);
		ll.print();

		System.out.println("Input the node: ");
		data = scanner.nextInt();
		ll.insertAtTail(data);
		ll.print();

		System.out.println("Head Node: " + ll.getHead());
		System.out.println("Tail Node: " + ll.getTail());
		System.out.println("2nd index Node: " + ll.getAtIndex(2));
		System.out.println("20th index Node: " + ll.getAtIndex(20));

		System.out.println("Deletion at Head: ");
		ll.deleteHead();
		ll.print();
		System.out.println("Head Node: " + ll.getHead());
		System.out.println("Tail Node: " + ll.getTail());
		System.out.println("2nd index Node: " + ll.getAtIndex(2));
		System.out.println("20th index Node: " + ll.getAtIndex(20));

		System.out.println("Deletion at Tail: ");
		ll.deleteTail();
		ll.print();
		System.out.println("Head Node: " + ll.getHead());
		System.out.println("Tail Node: " + ll.getTail());
		System.out.println("2nd index Node: " + ll.getAtIndex(2));
		System.out.println("20th index Node: " + ll.getAtIndex(20));

		System.out.println("Deletion at index = 2: ");
		ll.deleteAtIndex(2);
		ll.print();
		System.out.println("Head Node: " + ll.getHead());
		System.out.println("Tail Node: " + ll.getTail());
		System.out.println("2nd index Node: " + ll.getAtIndex(2));
		System.out.println("20th index Node: " + ll.getAtIndex(20));
	}
}