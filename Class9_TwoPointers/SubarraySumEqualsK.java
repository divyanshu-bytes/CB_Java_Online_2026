public class SubarraySumEqualsK{
	public static void subArraySumEqualsK(int[] arr, int k){
		int n = arr.length;
		int[] prefixSum = new int[n];

		prefixSum[0] = arr[0];
		for(int i=1; i<n; i++){
			prefixSum[i] = prefixSum[i-1] + arr[i];
		}

		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				int subarr_i_to_j_sum = 0;
				if(i == 0){
					subarr_i_to_j_sum = prefixSum[j];
				}
				else{
					subarr_i_to_j_sum = prefixSum[j] - prefixSum[i-1]; 
				}

				if(subarr_i_to_j_sum == k){
					System.out.println(i + ", " + j);
					return;
				}
			}
		}

		return;
	}

	public static void main(String[] args){
		int[] arr = {4,2,-3,1,6};
		// int k = 0;
		int k = 3;
		subArraySumEqualsK(arr, k);
	}
}







