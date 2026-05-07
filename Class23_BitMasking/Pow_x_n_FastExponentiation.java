class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n < 0){
            N = -1 * (long)n;
            x = 1.0 / x;
        }

        double ans = 1.0;
        while(N > 0){
            if((N % 2) == 0){
                x = x * x;
                N = N / 2;
            }
            else{
                ans = ans * x;
                N--;
            }
        }

        return ans;
    }
}