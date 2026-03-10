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

	public static void printAllSubarraysSum(int[] arr){
		int n = arr.length;
		// Print all subarrays
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				int subarraySum = 0;
				for(int k=i; k<=j; k++){
					System.out.print(arr[k] + " ");
					subarraySum += arr[k];
				}
				
				System.out.println("\t -> \t" + subarraySum);
			}
		}
		System.out.println();
	}


	public static void main(String[] args){

	}
}