public class MaximumSubarraySum{


	public static int maxSubarraysSumUsing3Loops(int[] arr){
		int n = arr.length;

		int maxSubarraysSum = Integer.MIN_VALUE;

		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				int currSubarraySum = 0;
				for(int k=i; k<=j; k++){
					currSubarraySum += arr[k];
				}

				if(currSubarraySum > maxSubarraysSum){
					maxSubarraysSum = currSubarraySum;
				}
			}
		}
		return maxSubarraysSum;
	}

	public static int maxSubarraysSumOptimizedUsing2Loops(int[] arr){
		int n = arr.length;

		int maxSubarraysSum = Integer.MIN_VALUE;

		for(int i=0; i<n; i++){
			int currSubarraySum = 0;
			for(int j=i; j<n; j++){
				// i, j
				currSubarraySum += arr[j];
				if(currSubarraySum > maxSubarraysSum){
					maxSubarraysSum = currSubarraySum;
				}
				// maxSubarraysSum = Math.max(maxSubarraysSum, currSubarraySum);
			}
		}
		return maxSubarraysSum;
	}


	public static void main(String[] args){
		int[] arr = {3,2,1,-6,5};	// hard code
		System.out.println("Max Subarray Sum (using 3 loops) : " + maxSubarraysSumUsing3Loops(arr));
		System.out.println("Max Subarray Sum Optimized (using 2 loops) : " + maxSubarraysSumOptimizedUsing2Loops(arr));
		
	}
}