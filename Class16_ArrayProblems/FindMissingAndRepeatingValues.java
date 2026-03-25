class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long N = n*n;

        long expected_sum_of_N_numbers = (N * (N + 1)) / 2;
        long expected_sum_of_squares_of_N_numbers = (N * (N + 1) * (2*N +1)) / 6;
        long actual_sum = 0;
        long actual_sum_of_squares = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                actual_sum += grid[row][col];
                actual_sum_of_squares += grid[row][col] * grid[row][col];
            }
        }

        long b_minus_a = expected_sum_of_N_numbers - actual_sum;
        long b2_minus_a2 = expected_sum_of_squares_of_N_numbers - actual_sum_of_squares;

        long b_plus_a = b2_minus_a2 / b_minus_a;
        long b = (b_plus_a + b_minus_a) / 2;
        long a = b_plus_a - b;

        return new int[]{(int)a, (int)b};
    }
}