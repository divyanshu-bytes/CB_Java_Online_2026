public class PrefixSum{
	public static void main(String[] args){
		int[] arr = {4,2,-3,1,6};
		int n = arr.length;
		int[] prefixSum = new int[n];

		prefixSum[0] = arr[0];
		for(int i=1; i<n; i++){
			prefixSum[i] = prefixSum[i-1] + arr[i];
		}

		for(int i=0; i<n; i++){
			System.out.print(arr[i] + "\t");		// 1 tab = spaces
		}

		for(int i=0; i<n; i++){
			System.out.print(prefixSum[i] + "\t");		// 1 tab = spaces
		}
	}
}