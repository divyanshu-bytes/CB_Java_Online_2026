import java.util.Scanner;

/*
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1
*/


public class RatInAMazeProactive{

	public static boolean isPossibleToGo(int[][] maze, int row, int col, boolean[][] visited){
		int n = maze.length;

		if(row < 0 || row >= n || col < 0 || col >= n || maze[row][col] == 0 || visited[row][col]){
			return false;
		}
		return true;
	}

	public static void findAllPaths(int[][] maze, int curRow, int curCol, int endRow, int endCol, StringBuilder moves, boolean[][] visited){
		if(isPossibleToGo(maze, curRow, curCol, visited) == false){
			return;
		}

		visited[curRow][curCol] = true;
		// Base Case
		if(curRow == endRow && curCol == endCol){
			// Reached destination - Print current path through which we have reached
			System.out.println(moves.toString());
			visited[curRow][curCol] = false;
			return;
		}

		String dirns = "DLRU";
		int[] dirRow = {1, 0, 0, -1};		// DLRU
		int[] dirCol = {0, -1, 1, 0};		// DLRU
		for(int k=0; k<4; k++){
			int newRow = curRow + dirRow[k];		// k = 0,1,2,3
			int newCol = curCol + dirCol[k];		// k = 0,1,2,3

			if(isPossibleToGo(maze, newRow, newCol, visited)){
				moves.insert(moves.length(), dirns.charAt(k));
				findAllPaths(maze, newRow, newCol, endRow, endCol, moves, visited);
				moves.deleteCharAt(moves.length()-1);		// Backtracking
			}
		}

		visited[curRow][curCol] = false;					// Backtracking
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