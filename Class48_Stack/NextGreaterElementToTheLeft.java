import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToTheLeft{

	public static int[] nextGreaterElementToTheLeft(int[] arr){
		int n = arr.length;
		int[] ngeLeft = new int[n];
		Stack<Integer> stk = new Stack<>();

		for(int i=n-1; i>=0; i--){
			while(!stk.empty() && arr[i] > stk.peek()){
				ngeLeft[stk.peek()] = arr[i];
				stk.pop();
			}

			stk.push(i);
		}

		while(!stk.empty()){
			ngeLeft[stk.peek()] = -1;
			stk.pop();
		}

		return ngeLeft;
	}

	public static void printArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = scanner.nextInt();
		}
		
		printArr(arr);
		int[] ngeLeft = nextGreaterElementToTheLeft(arr);
		printArr(ngeLeft);
	}
}