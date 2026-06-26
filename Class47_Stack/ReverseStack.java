import java.util.Scanner;

public class ReverseStack{

	public static Stack<Integer> reverseStackUsing2HelperStacks(Stack<Integer> stk){
		Stack<Integer> helper1 = new Stack<>();
		Stack<Integer> helper2 = new Stack<>();
		
		while(!stk.isEmpty()){
			helper1.push(stk.pop());
		}

		while(!helper1.isEmpty()){
			helper2.push(helper1.pop());
		}

		while(!helper2.isEmpty()){
			stk.push(helper2.pop());
		}

		return stk;
	}

	public void printStack(Stack<Integer> stk){
		System.out.print("Top -> ");
		while(!stk.isEmpty()){
			System.out.print(stk.peek() + " ");
			stk.pop();
		}
		System.out.println();
		return;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i=0; i<n; i++){
			stk.push(scanner.nextInt());
		}

		printStack(stk);
		stk = reverseStackUsing2HelperStacks(stk);
		printStack(stk);
	}
}