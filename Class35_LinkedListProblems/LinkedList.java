public class LinkedList{
	public Node head;

	// Constructor 1
	public LinkedList(){
		// Empty or No Arguments Constructor
	}

	// Constructor 2
	public LinkedList(int data){
		head = new Node(data);
	}

	public class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;		// this -> represents same class
			this.next = null;
		}
	}

	public void print(){
		System.out.println("Linked List: ");
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " -> ");		// . -> dot operator => used to access member variables / methods of a class
			temp = temp.next;
		}
		System.out.println("null");
	}

	public void insertAtHead(int data){
		// Step-1: create newNode with given data
		Node newNode = new Node(data);

		// Step-2: insert/attach newNode at head
		newNode.next = head;
		head = newNode;
		// print();
	}

	public void insertAtIndex(int data, int idx){
		if(idx == 0){
			// special case
			insertAtHead(data);
			return;
		}

		if(idx > size()){
			System.out.println("idx = " + idx + " is out of bounds");
			return;
		}

		Node temp = head;
		int i=0; 

		while(i < idx-1){
			temp = temp.next;
			i++;
		}

		Node newNode = new Node(data);
		newNode.next = temp.next;
		temp.next = newNode;
		return;
	}

	public void insertAtTail(int data){
		Node temp = head;
		while(temp != null && temp.next != null){
			temp = temp.next;
		}

		// Node newNode = new Node(data);
		// temp.next = newNode;

		temp.next = new Node(data);
		return;
	}

	public int size(){
		int size = 0;
		Node temp = head;

		while(temp != null){
			size++;
			temp = temp.next;
		}

		return size;
	}

	public int getHead(){
		if(head == null){
			return -1;
		}

		return head.data;
	}

	public int getTail(){
		if(head == null)
			return -1;

		Node temp = head;
		while(temp != null && temp.next != null){
			temp = temp.next;
		}
		return temp.data;
	}

	public int getAtIndex(int idx){
		if(head == null || idx > size()){
			return -1;
		}
		int i=0;
		Node temp = head;
		while(i < idx){
			temp = temp.next;
			i++;
		}

		return temp.data;
	}

	public void deleteHead(){
		if(head == null)
			return;
		head = head.next;
		return;
	}

	public void deleteTail(){
		if(head == null || head.next == null){
			head = null;
			return;
		}

		Node temp = head;
		while(temp.next.next != null){
			temp = temp.next;
		}
		temp.next = null;
		return;
	}

	public void deleteAtIndex(int idx){
		if(idx < 0 || idx > size()){
			System.out.println("idx = " + idx + " is out of bounds");
			return;
		}

		if(head == null){
			System.out.println("Empty Linked List");
			return;
		}

		if(idx == 0){
			deleteHead();
			return;
		}

		int i=0;
		Node temp = head;

		while(i < idx-1){
			temp = temp.next;
			i++;
		}
		temp.next = temp.next.next;
		return;
	}
}







