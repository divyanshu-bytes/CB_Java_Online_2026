// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        Map<Integer, Integer> prefixSumVsFirstIdxMap = new HashMap<>();
        
        prefixSumVsFirstIdxMap.put(0, -1);
        
        int maxLen = 0;
        int prefixSum = 0;
        for(int i=0; i<arr.length; i++){
            prefixSum += arr[i];
            
            if(prefixSumVsFirstIdxMap.containsKey(prefixSum - k)){
                int curLen = i - prefixSumVsFirstIdxMap.get(prefixSum - k);
                if(curLen > maxLen){
                    maxLen = curLen;
                }
            }
            
            if(!prefixSumVsFirstIdxMap.containsKey(prefixSum)){
                prefixSumVsFirstIdxMap.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}
