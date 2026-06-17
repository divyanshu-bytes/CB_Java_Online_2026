class Solution {
    public int findMaxLength(int[] nums) {
        // 0 -> wt = -1
        // 1 -> wt = +1
        HashMap<Integer, Integer> prefixSumVsFirstIdxMap = new HashMap<>();
        int prefixSum = -1;     // Empty Array => 0 => prefixSum = -1

        prefixSumVsFirstIdxMap.put(prefixSum, -1);

        int largestZeroSumSubarrayLen = 0;
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i] == 0 ? -1 : +1;

            // check if this prefixSum already occured at some previous idx, find its first occuring index
            if(prefixSumVsFirstIdxMap.containsKey(prefixSum)){
                int curZeroSumSubarrayLen = i -  prefixSumVsFirstIdxMap.get(prefixSum);
                if(curZeroSumSubarrayLen > largestZeroSumSubarrayLen){
                    largestZeroSumSubarrayLen = curZeroSumSubarrayLen;
                }
            }
            else{
                prefixSumVsFirstIdxMap.put(prefixSum, i);
            }
        }

        return largestZeroSumSubarrayLen;
    }
}