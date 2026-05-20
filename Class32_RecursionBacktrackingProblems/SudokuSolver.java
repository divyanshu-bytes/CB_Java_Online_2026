class Solution {

    boolean canPlaceNo(char[][] board, int row, int col, int no){
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

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if((board[gridStartX + i][gridStartY + j] - '0') == no){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solveSudokuRec(char[][] board, int row, int col){
        if(row == 9){
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

    public void solveSudoku(char[][] board) {
        solveSudokuRec(board, 0, 0);
    }
}