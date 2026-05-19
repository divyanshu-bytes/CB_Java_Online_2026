import java.util.Scanner;

/*

................................
.............#####..............
.............#...#..............
.......#######...#######........
.....####...#######...####......
....##...................##.....
...##.....................##....
...##.....................##....
....##...................##.....
.....##.................##......
......##...............##.......
.......###...........###........
.........#############..........
................................
...........A.P.P.L.E............
................................

*/


public class FloodFill{

	public static void printBoard(char[][] board){
		System.out.println("Board: ");
		int nRows = board.length;
		int nCols = board[0].length;

		for(int i=0; i<nRows; i++){
			for(int j=0; j<nCols; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean isValid(char[][] board, int x, int y, char srcColor){
		int nRows = board.length;
		int nCols = board[0].length;
		if(x < 0 || x >= nRows || y < 0 || y >= nCols || board[x][y] != srcColor){
			return false;
		}
		return true;
	}

	public static void floodFillPaint(char[][] board, int x, int y, char srcColor, char colorToFill){

		if(!isValid(board, x, y, srcColor)){
			return;
		}

		board[x][y] = colorToFill;
		printBoard(board);

		// Reactive
		floodFillPaint(board, x+1, y, srcColor, colorToFill);		// Down
		floodFillPaint(board, x, y+1, srcColor, colorToFill);		// Right
		floodFillPaint(board, x, y-1, srcColor, colorToFill);		// Left
		floodFillPaint(board, x-1, y, srcColor, colorToFill);		// Up
	}

	public static void main(String... args){
		Scanner scanner = new Scanner(System.in);
		char[][] board = new char[16][32];
		System.out.println("Input Board: ");
		for (int i = 0; i < 16; i++) {
		    String line = scanner.nextLine();   // read entire row
		    for (int j = 0; j < 32; j++) {
		        board[i][j] = line.charAt(j);
		    }
		}

		// Input Click Coordinates
		System.out.println("Input Click Coordinates: ");
		int x, y;
		x = scanner.nextInt();
		y = scanner.nextInt();

		System.out.println("Input source color: ");
		char srcColor = scanner.next().charAt(0);
		System.out.println("Input color to fill: ");
		char colorToFill = scanner.next().charAt(0);

		printBoard(board);
		floodFillPaint(board, x, y, srcColor, colorToFill);
		printBoard(board);
	}
}