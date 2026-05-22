import java.util.*;

/*

I/P:

5   3   .   .   7   .   .   .   . 
6   .   .   1   9   5   .   .   . 
.   9   8   .   .   .   .   6   . 
8   .   .   .   6   .   .   .   3 
4   .   .   8   .   3   .   .   1 
7   .   .   .   2   .   .   .   6 
.   6   .   .   .   .   2   8   . 
.   .   .   4   1   9   .   .   5 
.   .   .   .   8   .   .   7   9 


O/P:

5 3 4 6 7 8 9 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 

*/


public class Sudoku {

    public static boolean canPlaceNo(char[][] board, int row, int col, int no){
        // Row Check
        for(int i=0; i<9; i++){
            if((int)(board[row][i] - '0') == no){
                return false;
            }
        }

        // Column Check
        for(int i=0; i<9; i++){
            if((board[i][col] - '0') == no){
                return false;
            }
        }

        // Grid Check
        int gridStartX = 3 * (row / 3);
        int gridStartY = 3 * (col / 3);

        /*
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if((board[gridStartX + i][gridStartY + j] - '0') == no){
                    return false;
                }
            }
        }
        */

        for(int i=gridStartX; i<gridStartX+3; i++){
            for(int j=gridStartY; j<gridStartY+3; j++){
                if((board[i][j] - '0') == no){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudokuRec(char[][] board, int row, int col){
        if(row == 9){
            // Print board
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }

        if(col == 9){
            return solveSudokuRec(board, row+1, 0);
        }

        if(board[row][col] != '.'){
            return solveSudokuRec(board, row, col+1);
        }

        for(int no=1; no<=9; no++){
            if(canPlaceNo(board, row, col, no)){
                // System.out.println((char)('0' + no));
                board[row][col] = (char)('0' + no);
                boolean areWeAbleToSolveCompleteSudokuBoard = solveSudokuRec(board, row, col+1);
                if(areWeAbleToSolveCompleteSudokuBoard){
                    return true;
                }
                board[row][col] = '.';          // Backtracking                
            }
        }

        return false;
    }    

    public static void solveSudoku(char[][] board) {
        solveSudokuRec(board, 0, 0);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[9][9];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                board[i][j] = scanner.next().charAt(0);
            }
        }

        solveSudoku(board);
    }

}