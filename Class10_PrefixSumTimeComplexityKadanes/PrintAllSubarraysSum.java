public class PrintAllSubarraysSum{

	public static void printAllSubarrays(int[] arr){
		int n = arr.length;
		// Print all subarrays
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				for(int k=i; k<=j; k++){
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void printAllSubarraysAndSum(int[] arr){
		int n = arr.length;
		// Print all subarrays
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				int subarraySum = 0;
				for(int k=i; k<=j; k++){
					subarraySum += arr[k];
					System.out.print(arr[k] + " ");
				}
				System.out.println("\t -> \t\t" + subarraySum);	// 1 tab = 4 or 8 spaces
			}
		}
		System.out.println();
	}

	public static void printAllSubarraysSum(int[] arr){
		int n = arr.length;
		// Print all subarrays
		for(int i=0; i<n; i++){
			int subarraySum = 0;
			for(int j=i; j<n; j++){
				// i, j
				subarraySum += arr[j];
				System.out.println(i + " -> " + j + " : " + subarraySum);	// 1 tab = 4 or 8 spaces
			}
		}
		System.out.println();
	}


	public static void main(String[] args){
		int[] arr = {3,2,1,-6,5};	// hard code
		// printAllSubarrays(arr);
		System.out.println("All Subarray Sum: ");
		printAllSubarraysAndSum(arr);
		System.out.println("All Subarray Sum Optimized: ");
		printAllSubarraysSum(arr);
	}
}