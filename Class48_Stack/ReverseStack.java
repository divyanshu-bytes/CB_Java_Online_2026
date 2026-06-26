import java.util.Scanner;
import java.util.Stack;

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

	private static void transfer(Stack<Integer> srcStk, Stack<Integer> targetStk, int n){
		while(n-- > 0){
			targetStk.push(srcStk.pop());
		}
		return;
	}

	public static Stack<Integer> reverseStackUsing1HelperStack(Stack<Integer> stk){
		Stack<Integer> helper = new Stack<>();
		int n = stk.size();

		for(int i=0; i<n; i++){
			int x = stk.peek();
			stk.pop();

			transfer(stk, helper, n-i-1);
			stk.push(x);
			transfer(helper, stk, n-i-1);
		}

		return stk;
	}


	public static void printStack(Stack<Integer> stk){
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
		Stack<Integer> stk = new Stack<>();

		for(int i=0; i<n; i++){
			int elmt = scanner.nextInt();
			System.out.print(elmt + " ");
			stk.push(elmt);
		}

		System.out.println(" <- Top");
		
		// stk = reverseStackUsing2HelperStacks(stk);
		stk = reverseStackUsing1HelperStack(stk);
		printStack(stk);
	}
}