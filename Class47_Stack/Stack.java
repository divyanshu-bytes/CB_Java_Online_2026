public class Stack<T>{

	private T[] arr;
	private int top;
	private int capacity;

	public Stack(int size){
		arr = (T[]) new Object[size];
		capacity = size;
		top = -1;
	}

	public void push(T data){
		// ToDo: Insert data at the top of stack
		if(isFull()){
			System.out.println("Stack Overflow...");
			return;
		}
		arr[++top] = data;
	}

	public T pop(){
		// ToDo: Remove data from the top of stack and return it
		if(isEmpty()){
			System.out.println("Stack Underflow...");
			return null;
		}
		return arr[top--];
	}

	public T peek(){
		if(isEmpty()){
			System.out.println("Stack is Empty...");
			return null;
		}
		return arr[top];
	}

	public int size(){
		return top+1;
	}

	public boolean isEmpty(){
		return top == -1;
	}

	public boolean isFull(){
		return top == capacity-1;
	}

}