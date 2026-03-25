class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int repeating = -1;
        int missing = -1;
        int n = grid.length;

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                int curElmt = Math.abs(grid[row][col]);
                int expectedRow = (curElmt - 1) / n;
                int expectedCol = (curElmt - 1) % n;

                if(grid[expectedRow][expectedCol] < 0){
                    // already negative -> some element already visited this -> that element is repeating element
                    repeating = curElmt;
                    continue;
                }

                grid[expectedRow][expectedCol] = -1 * grid[expectedRow][expectedCol];
            }
        }

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col] > 0){
                    missing = (row * n) + (col + 1);
                }
            }
        }

        return new int[]{repeating, missing};
    }
}