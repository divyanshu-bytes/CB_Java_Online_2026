import java.util.*;

public class NQueens {

    public static boolean isPossibleToPlaceQueen(char[][] board, int row, int col){
        int n = board.length;
        // ToDo: 3 Steps:
        // Step-1: Vertical Check
        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // Step-2: Left Diagonal Check
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // Step-3: Right Diagonal Check
        for(int i=row, j=col; i>=0 && j<n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;        
    }

    public static void solveNQueensRec(char[][] board, int rowIdx, List<List<String>> ans){
        int n = board.length;
        if(rowIdx == n){
            List<String> config = new ArrayList<>();
            for(char[] row: board){
                config.add(String.valueOf(row));
            }
            ans.add(config);
            return;
        }

        for(int colIdx=0; colIdx<board.length; colIdx++){
            if(isPossibleToPlaceQueen(board, rowIdx, colIdx)){
                board[rowIdx][colIdx] = 'Q';
                solveNQueensRec(board, rowIdx+1, ans);
                board[rowIdx][colIdx] = '.';          // backtracking
            }
        }

    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] row: board){
            Arrays.fill(row, '.');
        }
        
        solveNQueensRec(board, 0, ans);
        
        return ans;
    }

    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<List<String>> ans = solveNQueens(n);  
        
        for(int i=0; i<ans.size(); i++){
            System.out.println("Config " + i + ": ");
            for(int j=0; j<ans.get(i).size(); j++){
                System.out.println(ans.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println();
    }
}