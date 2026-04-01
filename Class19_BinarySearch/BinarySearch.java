import java.util.Scanner;

public class BinarySearch{
	public static int binarySearch(int[] arr, int key){
		int n = arr.length;
		int lft = 0, ryt = n-1;

		while(lft <= ryt){
			int mid = (lft + ryt) / 2;
			if(arr[mid] == key){
				return mid;
			}
			else if(arr[mid] < key){
				lft = mid + 1;
			}
			else{
				// arr[mid] > key
				ryt = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int[] arr = {2,5,8,13,17,19,32,37,45};		// Sorted
		int key = scanner.nextInt();

		int foundAtIdx = binarySearch(arr, key);
		System.out.println(key + " found at idx = " + foundAtIdx);

	}
}