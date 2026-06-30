public class GenericQueue<T>{
	private T[] arr;		// only declare at class level
	private int front;
	private int rear;
	private int curSize;
	private int maxSize;

	public GenericQueue(int maxSize){
		front = 0;
		rear = maxSize - 1;
		arr = (T[]) new Object[maxSize];
		curSize = 0;
		this.maxSize = maxSize;
	}

	public void offer(T elmt){
		// push elmt to last
		if(isFull()){
			System.out.println("Queue is Already Full...");
			return;
		}
		rear = (rear + 1) % maxSize;
		arr[rear] = elmt;
		curSize++;
	}

	public T poll(){
		// pop elmt from front and also return popped element
		if(isEmpty()){
			System.out.println("Queue is Empty...");
			return null;
		}

		T poppedElmt = arr[front];
		front = (front + 1) % maxSize;
		curSize--;
		return poppedElmt;
	}

	public T peek(){
		// read elmt from front
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