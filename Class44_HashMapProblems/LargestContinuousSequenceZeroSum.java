public class Solution {
    public int[] lszero(int[] A) {
        int[] ans = new int[2];     // startIdx, endIdx
        
        HashMap<Integer, Integer> prefixSumVsFirstIdxMap = new HashMap<>();
        int prefixSum = 0;
        prefixSumVsFirstIdxMap.put(prefixSum, -1);
        
        int largestZeroSubarrLen = 0;
        for(int i=0; i<A.length; i++){
            prefixSum += A[i];
            
            if(prefixSumVsFirstIdxMap.containsKey(prefixSum)){
                int curZeroSubarrLen = i - prefixSumVsFirstIdxMap.get(prefixSum);
                if(curZeroSubarrLen > largestZeroSubarrLen){
                    largestZeroSubarrLen = curZeroSubarrLen;
                    ans[0] = prefixSumVsFirstIdxMap.get(prefixSum) + 1;
                    ans[1] = i;
                }
            }
            else{
                prefixSumVsFirstIdxMap.put(prefixSum, i);
            }
        }
        
        int[] ansArr = new int[largestZeroSubarrLen];
        if(largestZeroSubarrLen == 0){
            return ansArr;
        }

        int k = 0;
        for(int i=ans[0]; i<=ans[1]; i++){
            ansArr[k++] = A[i];
        }
        
        return ansArr;
    }
}
