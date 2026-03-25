import java.util.Scanner;

public class WavePrint2Array{

	public static void print2DArray(int[][] arr){
		int nRows = arr.length;		// Rows
		int nCols = arr[0].length;	// Columns

		// Print row wise
		for(int row=0; row<nRows; row++){
			for(int col=0; col<nCols; col++){
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public static void print2DArrayInWaveForm(int[][] arr){
		int nRows = arr.length;		// Rows
		int nCols = arr[0].length;	// Columns

		// Print Column wise
		for(int col=0; col<nCols; col++){
			// col -> 0,1,2,3,...,(nCols-1)

			if(col % 2 == 0){
				// Even no Column
				for(int row=0; row<nRows; row++){
					System.out.print(arr[row][col] + " ");
				}
			}
			else{
				// Odd no Column
				for(int row=nRows-1; row>=0; row--){
					System.out.print(arr[row][col] + " ");
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args){
		// int[][] arr2D = new int[2][3];

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of Rows and Columns: ");
		int nRows = scanner.nextInt();
		int nCols = scanner.nextInt();

		int[][] arr2D = new int[nRows][nCols];

		System.out.println("Enter 2D Array Elements: ");		
		for(int row=0; row<nRows; row++){
			for(int col=0; col<nCols; col++){
				arr2D[row][col] = scanner.nextInt();
			}
		}

		System.out.println("Prinitng 2D Array: ");
		print2DArray(arr2D);

		System.out.println("Prinitng 2D Array in Wave Form: ");
		print2DArrayInWaveForm(arr2D);

	}
}