import java.util.Scanner;
import java.util.Stack;

public class StockSpan{

	public static int[] calculateStockSpan(int[] price){
        Stack<Integer> stk = new Stack<>();			// stk -> idx

        int n = price.length;
        int[] span = new int[n];
        for(int i=0; i<n; i++){
        	while(!stk.isEmpty() && price[i] >= price[stk.peek()]){
        		stk.pop();
        	}

        	if(stk.isEmpty()){
        		span[i] = i + 1;
        	}
        	else{
        		span[i] = i - stk.peek();
        	}

        	stk.push(i);
        }
        return span;
    }

    public static void printArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}


	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] price = new int[n];

		for(int i=0; i<n; i++)
			price[i] = scanner.nextInt();

		System.out.println();
		printArr(price);		
		int[] span = calculateStockSpan(price);
		printArr(span);
	}
}