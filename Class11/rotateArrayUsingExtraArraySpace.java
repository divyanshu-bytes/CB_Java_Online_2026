class Solution {

    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        
        int[] ans = new int[n];

        int base = n-k;
        int i = 0;

        while(i < n){
            ans[i] = arr[(base + i) % n];
            i++;
        }

        for(i=0; i<n; i++){
            arr[i] = ans[i];
        }

        return;
    }
}