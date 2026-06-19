public class Solution {
    public int[] dNums(int[] arr, int k) {
        HashMap<Integer, Integer> elmtVsCountMap = new HashMap<>();
        
        int n = arr.length;
        int[] ans = new int[n-k+1];
        for(int i=0; i<k; i++){
            elmtVsCountMap.put(arr[i], elmtVsCountMap.getOrDefault(arr[i], 0) + 1);
        }
        
        int p=0;
        ans[p++] = elmtVsCountMap.size();
        
        for(int j=k; j<n; j++){
            // remove starting element of window and add jth element in window 
            int windowStartEl = arr[j-k];
            elmtVsCountMap.put(windowStartEl, elmtVsCountMap.get(windowStartEl)-1);
            
            if(elmtVsCountMap.get(windowStartEl) == 0){
                elmtVsCountMap.remove(windowStartEl);
            }
            
            int newElmt = arr[j];
            elmtVsCountMap.put(newElmt, elmtVsCountMap.getOrDefault(newElmt, 0) + 1);
            
            ans[p++] = elmtVsCountMap.size();
        }
        
        return ans;
    }
}
