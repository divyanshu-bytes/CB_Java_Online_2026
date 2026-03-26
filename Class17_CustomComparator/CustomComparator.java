import java.util.*;

public class CustomComparator{

	public static class MySquareBasedComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer a, Integer b){
			return Integer.compare(a*a, b*b);
		}
	}

	public static class MyElementByKBasedComparatorAsc implements Comparator<Integer>{
		int k;
		public MyElementByKBasedComparatorAsc(int k){
			this.k = k;
		}

		@Override
		public int compare(Integer a, Integer b){
			return Integer.compare(a / k, b / k);
		}
	}

	public static class MyElementByKBasedComparatorDesc implements Comparator<Integer>{
		int k;
		public MyElementByKBasedComparatorDesc(int k){
			this.k = k;
		}

		@Override
		public int compare(Integer a, Integer b){
			return Integer.compare(b / k, a / k);
		}
	}

	public static class MyAbsoluteValueBasedComparatorAsc implements Comparator<Integer>{
		@Override
		public int compare(Integer a, Integer b){
			return Integer.compare(Math.abs(a), Math.abs(b));
		}
	}

	public static class MyAbsoluteValueBasedComparatorDesc implements Comparator<Integer>{
		@Override
		public int compare(Integer a, Integer b){
			return Integer.compare(Math.abs(b), Math.abs(a));
		}
	}


	public static void printArray(Integer[] arr){
		int n = arr.length;
		// Print the array elements
		System.out.println("Printing the Array: ");
		for(int i=0; i<n; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		Integer[] arr = {-8,3,0,-1,5,2,-6,13};
		
		System.out.println("Before Sorting: ");
		printArray(arr);
		
		Arrays.sort(arr);

		System.out.println("After Sorting (Arrays.sort()): ");
		printArray(arr);
		System.out.println();

		arr = new Integer[]{-8,3,0,-1,5,2,-6,13};

		System.out.println("Before Sorting: ");
		printArray(arr);

		Arrays.sort(arr, new MySquareBasedComparator());

		System.out.println("After Sorting (Arrays.sort(arr, new MySquareBasedComparator())): ");
		printArray(arr);
		System.out.println();

		arr = new Integer[]{-8,3,0,-1,5,2,-6,13};

		System.out.println("Before Sorting: ");
		printArray(arr);

		Arrays.sort(arr, new MyAbsoluteValueBasedComparatorAsc());

		System.out.println("After Sorting (Arrays.sort(arr, new MyAbsoluteValueBasedComparatorAsc())): ");
		printArray(arr);
		System.out.println();

		arr = new Integer[]{-8,3,0,-1,5,2,-6,13};

		System.out.println("Before Sorting: ");
		printArray(arr);

		Arrays.sort(arr, new MyAbsoluteValueBasedComparatorDesc());

		System.out.println("After Sorting (Arrays.sort(arr, new MyAbsoluteValueBasedComparatorDesc())): ");
		printArray(arr);
		System.out.println();

		arr = new Integer[]{-8,3,0,-1,5,2,-6,13};

		System.out.println("Before Sorting: ");
		printArray(arr);

		Arrays.sort(arr, new MyElementByKBasedComparatorAsc(5));

		System.out.println("After Sorting (Arrays.sort(arr, new MyElementByKBasedComparatorAsc())): ");
		printArray(arr);
		System.out.println();

		arr = new Integer[]{-8,3,0,-1,5,2,-6,13};

		System.out.println("Before Sorting: ");
		printArray(arr);

		Arrays.sort(arr, new MyElementByKBasedComparatorDesc(5));

		System.out.println("After Sorting (Arrays.sort(arr, new MyElementByKBasedComparatorDesc())): ");
		printArray(arr);
		System.out.println();

		

	}
}







