import java.util.*;

/*

Input:
9
-2 1 -3 4 -1 2 1 -5 4

*/

public class MaximumSubarraySum{

	public static void printAllSubarrays(int[] arr){
		int n = arr.length;
		// Print all subarrays
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// for subarray i to j
				for(int k=i; k<=j; k++){
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}

	public static int maximumSubarraySum(int[] arr){
		// Bruteforce - using 3 loops
		int n = arr.length;
		int maxSubArrSum = Integer.MIN_VALUE;

		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// for subarray i to j
				int currentSubarraySum = 0;
				for(int k=i; k<=j; k++){
					currentSubarraySum += arr[k];
				}

				if(currentSubarraySum > maxSubArrSum){
					maxSubArrSum = currentSubarraySum;
				}
			}
		}
		return maxSubArrSum;
	}

	public static int maximumSubarraySumOptimized(int[] arr){
		// Optimized - using 2 loops
		int n = arr.length;
		int maxSubArrSum = Integer.MIN_VALUE;

		for(int i=0; i<n; i++){
			int currentSubarraySum = 0;
			for(int j=i; j<n; j++){
				// for subarray i to j
				currentSubarraySum += arr[j];

				if(currentSubarraySum > maxSubArrSum){
					maxSubArrSum = currentSubarraySum;
				}
			}
		}
		return maxSubArrSum;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] arr = new int[n];

		// take array input
		for(int i=0; i<n; i++){
			arr[i] = scanner.nextInt();
		}

		System.out.println("Maximum Subarray Sum = " + maximumSubarraySum(arr));
		System.out.println("Maximum Subarray Sum Optimized Way = " + maximumSubarraySumOptimized(arr));
	}
}