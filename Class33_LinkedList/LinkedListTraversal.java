public class LinkedListTraversal{

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

	/*
	public static void traverseLinkedList(LinkedListNode head){
		while(head != null){
			System.out.println(head.data);
			head = head.next;
		}
		return;
	}
	*/

	public static void main(String[] args){
		LinkedListNode head = new LinkedListNode(5);
		LinkedListNode node1 = new LinkedListNode(6);
		LinkedListNode node2 = new LinkedListNode(1);
		LinkedListNode node3 = new LinkedListNode(3);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;

		traverseLinkedList(head);
	}
}