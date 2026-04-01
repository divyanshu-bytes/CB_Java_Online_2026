public class SpiralOrderTraversal{
    public static void spiralOrderTraversal(int[][] matrix){
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        int begRow = 0, endRow = nRows-1;
        int begCol = 0, endCol = nCols-1;

        while(begRow <= endRow){
            // Step-1: begRow 
            int col = begCol;
            while(col <= endCol){
                System.out.println(matrix[begRow][col]);
                col++;
            }
            begRow++;


            // Step-2: endCol
            int row = begRow;
            while(row <= endRow){
                System.out.println(matrix[row][endCol]);
                row++;
            }
            endCol--;

            // Step-3: endRow
            col = endCol;
            while(col >= begCol){
                System.out.println(matrix[endRow][col]);
                col--;
            }
            endRow--;

            // Step-4: begCol
            row = endRow;
            while(row >= begRow){
                System.out.println(matrix[row][begCol]);
                row--;
            }
            begCol++;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int nRows = scanner.nextInt();
        int nCols = scanner.nextInt();
        int[][] matrix = new int[nRows][nCols];

        for(int row=0; row<nRows; row++){
            for(int col=0; col<nCols; col++){
                matrix[row][col] = scanner.nextInt();
            }
        }

        spiralOrderTraversal(matrix);

    }
}