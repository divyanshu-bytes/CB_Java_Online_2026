public class StackDemo{
	public static void main(String[] args){
		Stack<Integer> stk = new Stack<>(5);
		stk.push(5);
		stk.push(3);
		stk.push(1);
		stk.push(2);

		System.out.println("Size: " + stk.size());

		
		System.out.println("Top Element: " + stk.peek());
		int poppedElmt = stk.pop();
		System.out.println("Popped Element: " + poppedElmt);
		System.out.println("Top Element: " + stk.peek());

		poppedElmt = stk.pop();
		System.out.println("Popped Element: " + poppedElmt);
		System.out.println("Top Element: " + stk.peek());

		stk.push(8);
		stk.push(6);
		stk.push(12);
		stk.push(32);
		stk.push(11);
		stk.push(27);
		System.out.println("Top Element: " + stk.peek());
	}
}