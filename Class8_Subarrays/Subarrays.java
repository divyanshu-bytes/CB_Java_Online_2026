import java.util.Scanner;
import java.util.*;

public class Subarrays{

	/*
	public static void printAllSubarrays(int[] arr){
		int n = arr.length;
		// Print all subarrays
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				for(int k=i; k<=j; k++){
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	*/

	public static void printSubarray(int[] arr, int i, int j){
		for(int k=i; k<=j; k++){
			System.out.print(arr[k] + " ");
		}
		System.out.println();
	}

	public static void printAllSubarrays(int[] arr){
		int n = arr.length;
		// Print all subarrays
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				printSubarray(arr, i, j);
			}
		}
		System.out.println();
	}

	public static ArrayList<ArrayList<Integer>> getAllSubarrays(int[] arr){
		int n = arr.length;
		int totalSubarrays = (n * (n + 1)) / 2;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		// Print all subarrays
		for(int i=0; i<n; i++){
			ArrayList<Integer> subArray = new ArrayList<>();
			for(int j=i; j<n; j++){
				subArray.add(arr[j]);
				ans.add(new ArrayList<>(subArray));
			}
		}
		return ans;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];

		// take array input
		for(int i=0; i<n; i++){
			arr[i] = scanner.nextInt();
		}

		printAllSubarrays(arr);
		
		// ArrayList<ArrayList<Integer>> ans = getAllSubarrays(arr);
		// for(int i=0; i<ans.size(); i++){
		// 	for(int j=0; j<ans.get(i).size(); j++){
		// 		System.out.print(ans.get(i).get(j) + " ");
		// 	}
		// 	System.out.println();
		// }
	}
}