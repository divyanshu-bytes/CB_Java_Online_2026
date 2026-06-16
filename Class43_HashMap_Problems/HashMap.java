public class HashMap<T,U>{

	// HashMap<String, Integer> m = new HashMap<>();
	public class Node<T,U>{
		T key;
		U value;
		Node next;

		public Node(T key, U value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	private Node<T,U>[] hashTable;		// declare
	private int tableSize;		// prime No
	private int curMapSize;
	private double THRESHOLD_LOAD_FACTOR = 0.6;

	public HashMap(){
		tableSize = 7;
		hashTable = new Node[tableSize];		// memory assigned to hashTable
		curMapSize = 0;
	}

	private int hashFn(T key){
		String str = String.valueOf(key);
		int primeNo = 37;
		int primeFactor = 1;			// 37^0 = 1
		// bat -> 37^0 x b + 37^1 x a + 37^2 x t
		int val = 0;
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			val = (val + (primeFactor * ch)) % tableSize;
			primeFactor = (primeFactor * primeNo) % tableSize;		// primeFactor = 1 * 37 = 37, primeFactor = 37 * 37 = 37^2
		}
		return val % tableSize;
	}

	private Node insert(Node head, T key, U value){
		Node newNode = new Node(key, value);

		if(head == null){
			head = newNode;
			curMapSize++;
			return head;
		}

		Node temp = head;
		Node prev = null;
		while(temp != null){
			if(temp.key == key){
				temp.value = value;
				return head;
			}
			prev = temp;
			temp = temp.next;
		}

		prev.next = newNode;
		curMapSize++;
		return head;
	}

	private void printHashTable(){
		System.out.println("HashTable: ");
		for(int i=0; i<tableSize; i++){
			Node head = hashTable[i];
			Node temp = head;
			System.out.print("idx = " + i + " -> ");
			while(temp != null){
				System.out.print("(" + temp.key + ", " + temp.value + ") -> ");
				temp = temp.next;
			}
			System.out.println("null");
		}
		System.out.println();
	}

	private void rehash(){
		System.out.println("Rehashing...");
		int tableSizeOld = tableSize;			// tableSize = 11, tableSizeOld = 11
		Node<T,U>[] hashTableOld = hashTable;

		curMapSize = 0;
		tableSize = 2 * tableSize;				// tableSize = 22
		hashTable = new Node[tableSize];

		for(int i=0; i<tableSizeOld; i++){
			Node head = hashTableOld[i];
			Node temp = head;
			while(temp != null){
				put((T)temp.key, (U)temp.value);
				temp = temp.next;
			}
		}
		return;
	}

	public void put(T key, U value){
		int idx = hashFn(key);		// idx lies in range (0 to (tableSize-1))
		Node head = hashTable[idx];
		hashTable[idx] = insert(head, key, value);

		double loadFactor = (1.0 * curMapSize) / tableSize;

		if(loadFactor > THRESHOLD_LOAD_FACTOR){
			System.out.println("Load Factor = " + loadFactor + " exceeded from THRESHOLD_LOAD_FACTOR = " + THRESHOLD_LOAD_FACTOR);
			// printHashTable();
			rehash();
			// printHashTable();
		}
	}

	private Node delete(Node head, T key){
		if(head != null){
			if(head.key == key){
				head = head.next;
				curMapSize--;
				return head;
			}
		}
		// search key in linked list represented by head
		Node temp = head;
		Node prev = null;
		while(temp != null){
			if(temp.key == key){
				prev.next = temp.next;
				curMapSize--;
				return head;
			}
			prev = temp;
			temp = temp.next;
		}
		System.out.println("Key Not found");
		return head;
	}

	public void remove(T key){
		int idx = hashFn(key);		// hashFn() -> deterministic
		Node head = hashTable[idx];
		hashTable[idx] = delete(head, key);
	}

	// get -> search
	public U get(T key){
		int idx = hashFn(key);
		Node head = hashTable[idx];
		Node temp = head;
		while(temp != null){
			if(temp.key == key){
				return (U) temp.value;
			}
			temp = temp.next;
		}
		return null;
	}

	public int size(){
		return this.curMapSize;
	}

}