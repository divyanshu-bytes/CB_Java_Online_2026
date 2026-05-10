import java.util.Scanner;

public class CheckArraySorted{

	public static boolean isArraySortedHelper(int[] arr, int idx){
		if(idx == arr.length-1)
			return true;

		boolean selfWorkAns = arr[idx] < arr[idx+1];
		boolean nextAnsByRecursion = isArraySortedHelper(arr, idx+1);
		if(selfWorkAns && nextAnsByRecursion)
			return true;
		else
			return false;
	}

	public static boolean isArraySortedHelper(int[] arr, int idx){
		if(idx == arr.length-1)
			return true;

		return (arr[idx] < arr[idx+1]) && isArraySortedHelper(arr, idx+1);
	}

	public static boolean isArraySorted(int[] arr){
		return isArraySortedHelper(arr, 0);
	}	

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = scanner.nextInt();

		if(isArraySorted(arr))
			System.out.println("Sorted");
		else
			System.out.println("Not Sorted");
	}
}