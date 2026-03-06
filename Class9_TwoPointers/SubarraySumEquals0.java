public class SubarraySumEquals0{
	public static boolean subArraySumEqualsZeroPrefixSum(int[] arr){
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

				if(subarr_i_to_j_sum == 0){
					return true;
				}
			}
		}

		return false;
	}

	public static boolean subArraySumEqualsZero(int[] arr){
		int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                // i have values of both i and j
                
                int subarraySum = 0;
                
                for(int k=i; k<=j; k++){
                    subarraySum += arr[k];
                }
                
                if(subarraySum == 0){
                    return true;
                }
            }
        }
        
        return false;
    }

    public static boolean subArraySumEqualsZeroOptimized(int[] arr){
		int n = arr.length;
        for(int i=0; i<n; i++){
            int subarraySum = 0;

            for(int j=i; j<n; j++){
                // i have values of both i and j
                subarraySum += arr[j];
                
                if(subarraySum == 0){
                    return true;
                }
            }
        }
        
        return false;
    }

	public static void main(String[] args){
		int[] arr = {4,2,-3,1,6};
		// if(subArraySumEqualsZero(arr))
		// 	System.out.println("True");
		// else
		// 	System.out.println("False");


		// All are same things: 
		// boolean ans = subArraySumEqualsZero(arr);
		// System.out.println(ans == true ? "True" : "False");
		// System.out.println(ans ? "True" : "False");
		// System.out.println(subArraySumEqualsZero(arr) == true ? "True" : "False");
		System.out.println(subArraySumEqualsZero(arr) ? "True" : "False");
		System.out.println(subArraySumEqualsZeroPrefixSum(arr) ? "True" : "False");
		System.out.println(subArraySumEqualsZeroOptimized(arr) ? "True" : "False");
	}
}







