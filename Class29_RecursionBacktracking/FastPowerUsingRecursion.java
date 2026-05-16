class Solution {
    public double myPowHelper(double x, int n) {
        if(n == 0){
            return 1;
        }
        double smallAns = myPowHelper(x, n/2);
        smallAns = smallAns * smallAns;
        if((n % 2) == 0){
            // n -> Even
            return smallAns;
        }        
        // n -> odd
        return x * smallAns;
    }

    public double myPow(double x, int n) {
        int N = Math.abs(n);
        double ans = myPowHelper(x, N); // x^N

        if(n < 0){      
            return 1.0 / ans;
        }
        return ans;
    }
}


