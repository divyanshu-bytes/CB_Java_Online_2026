import java.util.Scanner;

/*
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1
*/


public class RatInAMaze{

	public static boolean isPossibleToGo(int[][] maze, int row, int col, boolean[][] visited){
		int n = maze.length;

		if(row < 0 || row >= n || col < 0 || col >= n || maze[row][col] == 0 || visited[row][col]){
			return false;
		}
		return true;
	}

	public static void findAllPaths(int[][] maze, int curRow, int curCol, int endRow, int endCol, StringBuilder moves, boolean[][] visited){
		visited[curRow][curCol] = true;
		// Base Case
		if(curRow == endRow && curCol == endCol){
			// Reached destination - Print current path through which we have reached
			System.out.println(moves.toString());
			visited[curRow][curCol] = false;
			return;
		}


		// Down - D
		if(isPossibleToGo(maze, curRow+1, curCol, visited)){
			moves.insert(moves.length(), "D");
			findAllPaths(maze, curRow+1, curCol, endRow, endCol, moves, visited);
			moves.deleteCharAt(moves.length()-1);		// Backtracking
		}

		// Left - L
		if(isPossibleToGo(maze, curRow, curCol-1, visited)){
			moves.insert(moves.length(), "L");
			findAllPaths(maze, curRow, curCol-1, endRow, endCol, moves, visited);
			moves.deleteCharAt(moves.length()-1);		// Backtracking
		}

		// Right - R
		if(isPossibleToGo(maze, curRow, curCol+1, visited)){
			moves.insert(moves.length(), "R");
			findAllPaths(maze, curRow, curCol+1, endRow, endCol, moves, visited);	
			moves.deleteCharAt(moves.length()-1);		// Backtracking		
		}

		// Up - U
		if(isPossibleToGo(maze, curRow-1, curCol, visited)){
			moves.insert(moves.length(), "U");
			findAllPaths(maze, curRow-1, curCol, endRow, endCol, moves, visited);
			moves.deleteCharAt(moves.length()-1);		// Backtracking
		}

		visited[curRow][curCol] = false;		// backtracking
	}

	public static void ratInAMaze(int[][] maze){
		int n = maze.length;
		boolean[][] visited = new boolean[n][n];	// by default all values are false 
		StringBuilder moves = new StringBuilder();		// initially empty
		findAllPaths(maze, 0, 0, n-1, n-1, moves, visited);			// print all paths from 0,0 to n-1,n-1
	}

	public static void main(String... args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = scanner.nextInt();

		System.out.println("Enter maze of size " + n + " x " + n + ": ");
		int[][] maze = new int[n][n];

		for(int row=0; row<n; row++){
			for(int col=0; col<n; col++){
				maze[row][col] = scanner.nextInt();
			}
		}

		ratInAMaze(maze);			// print all paths from 0,0 to n-1,n-1
	}
}