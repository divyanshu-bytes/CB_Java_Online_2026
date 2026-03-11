import java.util.*;

/*

Input:
9
-2 1 -3 4 -1 2 1 -5 4

*/

public class MaximumSubarraySumUsingKadanesAlgo{

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

	public static int maximumSubarraySumUsingPrefixSum(int[] arr){
		// Optimized - using 2 loops
		int n = arr.length;

		int[] prefixSum = new int[n];
		prefixSum[0] = arr[0];
		for(int i=1; i<n; i++){
			prefixSum[i] = prefixSum[i-1] + arr[i];
		}

		int maxSubArrSum = Integer.MIN_VALUE;

		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// for subarray i to j
				int currentSubarraySum = 0;

				if(i == 0){
					currentSubarraySum = prefixSum[j];
				}
				else{
					currentSubarraySum = prefixSum[j] - prefixSum[i-1];
				}

				if(currentSubarraySum > maxSubArrSum){
					maxSubArrSum = currentSubarraySum;
				}
			}
		}
		return maxSubArrSum;
	}

	public static int maximumSubarraySumUsingKadanesAlgo(int[] arr){
		// long maxSoFar = Integer.MIN_VALUE;
		// long maxEndingHere = Integer.MIN_VALUE;

		int maxSoFar = arr[0];
		int maxEndingHere = arr[0];

		for(int i=1; i<arr.length; i++){
			maxEndingHere = Math.max(maxEndingHere + arr[i], arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;
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
		System.out.println("Maximum Subarray Sum using Optimized Way = " + maximumSubarraySumOptimized(arr));
		System.out.println("Maximum Subarray Sum using Prefix Sum = " + maximumSubarraySumUsingPrefixSum(arr));
		System.out.println("Maximum Subarray Sum using Kadanes Algorithm = " + maximumSubarraySumUsingKadanesAlgo(arr));
	}
}