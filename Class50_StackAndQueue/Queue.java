public class Queue{
	private int[] arr;		// only declare at class level
	private int front;
	private int rear;
	private int curSize;
	private int maxSize;

	public Queue(int maxSize){
		front = 0;
		rear = maxSize - 1;
		arr = new int[maxSize];
		curSize = 0;
		this.maxSize = maxSize;
		System.out.println("Front = " + front + " | Rear = " + rear);
	}

	public void offer(int elmt){
		// push elmt to last
		if(isFull()){
			System.out.println(elmt + " not pushed. Queue is Already Full...");
			return;
		}
		rear = (rear + 1) % maxSize;
		arr[rear] = elmt;
		curSize++;
		System.out.println("Pushed " + elmt);
		System.out.println("Front = " + front + " | Rear = " + rear);
	}

	public int poll(){
		// pop elmt from front and also return popped element
		if(isEmpty()){
			System.out.println("Queue is Empty...");
			return -1;
		}

		int poppedElmt = arr[front];
		front = (front + 1) % maxSize;
		curSize--;
		System.out.println("Front = " + front + " | Rear = " + rear);
		return poppedElmt;
	}

	public int peek(){
		// read elmt from front
		if(isEmpty()){
			System.out.println("Queue is Empty...");
			return -1;
		}
		return arr[front];
	}

	public int size(){
		return curSize;
	}

	public boolean isEmpty(){
		return curSize == 0;
	}

	public boolean isFull(){
		return curSize == maxSize;
	}
}