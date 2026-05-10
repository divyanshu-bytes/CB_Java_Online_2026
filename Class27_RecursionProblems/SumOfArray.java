import java.util.Scanner;

public class SumOfArray{


	public static int sumOfArray(int[] arr, int idx){
		if(idx == arr.length)
			return 0;

		/*
		// Alternate Base Case:
		if(idx == arr.length-1)
			return arr[idx];
		*/

		return arr[idx] + sumOfArray(arr, 0);
	}	

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = scanner.nextInt();

		System.out.println(sumOfArray(arr, 0));
	}
}