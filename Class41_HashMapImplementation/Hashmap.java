public class Hashmap{

	public class Node{
		String key;
		int value;
		Node next;

		public Node(String key, int value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	public Node[] hashTable;		// declare
	public int tableSize = 47;		// prime No
	public int curSize;


	public Hashmap(){
		hashTable = new Node[tableSize];		// memory assigned to hashTable
		curSize = 0;
	}

	private int hashFn(String key){
		int primeNo = 37;
		int primeFactor = 1;			// 37^0 = 1
		// bat -> 37^0 x b + 37^1 x a + 37^2 x t
		int val = 0;
		for(int i=0; i<key.length(); i++){
			char ch = key.charAt(i);
			val = (val + (primeFactor * ch)) % tableSize;
			primeFactor = (primeFactor * primeNo) % tableSize;		// primeFactor = 1 * 37 = 37, primeFactor = 37 * 37 = 37^2
		}
		return val;
	}

	public void put(String key, int value){
		int idx = hashFn(key);		// idx lies in range (0 to (tableSize-1))
		Node head = hashTable[idx];
		Node newNode = new Node(key, value);
		if(head == null){
			head = newNode;
			hashTable[idx] = head;
		}
		else{
			newNode.next = head;
			head = newNode;
		}
		curSize++;
	}

	public void erase(String key){
		int idx = hashFn(key);		// hashFn() -> deterministic
		Node head = hashTable[idx];
		if(head != null){
			if(head.key == key){
				hashTable[idx] = head.next;
				curSize--;
				return;
			}
		}
		// search key in linked list represented by head
		Node temp = head;
		Node prev = null;
		while(temp != null){
			if(temp.key == key){
				prev.next = temp.next;
				curSize--;
				return;
			}
			prev = temp;
			temp = temp.next;
		}
	}

	public int search(String key){
		int idx = hashFn(key);
		Node head = hashTable[idx];
		Node temp = head;
		while(temp != null){
			// System.out.print(temp.key + " ");
			if(temp.key == key){
				return temp.value;
			}
			temp = temp.next;
		}
		return -1;
	}

	public int size(){
		return curSize;
	}

}