public class DoublyLinkedList{

	public class DLLNode<T>{
		public T data;
		public DLLNode prev;
		public DLLNode next;

		public DLLNode(T data){
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	public DLLNode head;
	public int size;

	public DoublyLinkedList(){
		head = null;
		size = 0;
	}

	public void insertAtHead(T data){
		DLLNode newNode = new DLLNode(data);
		if(head == null){
			head = newNode;
			size++;
			return;
		}

		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		size++;
	}

	public void insertAtIndex(T data, int idx){
		DLLNode temp = head;
		int i=0; 
		while(i<idx){
			temp = temp.next;
			i++;
		}

		DLLNode newNode = new DLLNode(data);
		newNode.next = temp;
		newNode.prev = temp.prev;
		temp.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}

	public void deleteHead(){
		if(head == null){
			return;
		}

		if(head.next == null){
			size--;
			head = null;
			return;
		}

		head = head.next;
		head.prev = null;
		size--;
	}

	public void deleteAtIndex(T data, int idx){
		if(head == null || idx < 0 || idx > size){
			return;
		}
		int i=0; 
		while(i < idx){
			temp = temp.next;
			i++;
		}

		DLLNode temp = head;
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp.next = null;
		temp.prev = null;
		size--;
	}

	public int size(){
		return this.size;
	}

}