import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementToTheRight{

	public static int[] nextSmallerElementToTheRight(int[] arr){
		int n = arr.length;
		Stack<Integer> stk = new Stack<>();
		int[] nseRight = new int[n];

		for(int i=0; i<n; i++){
			while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
				nseRight[stk.peek()] = arr[i];
				stk.pop();
			}
			stk.push(i);
		}

		while(!stk.isEmpty()){
			nseRight[stk.peek()] = -1;
			stk.pop();
		}

		return nseRight;
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
		int[] nseRight = nextSmallerElementToTheRight(arr);
		printArr(nseRight);

	}
}