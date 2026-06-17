class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumVsCountMap = new HashMap<>();
        int prefixSum = 0;
        prefixSumVsCountMap.put(prefixSum, 1);

        int ansCount = 0;
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];

            if(prefixSumVsCountMap.containsKey(prefixSum - k)){
                ansCount += prefixSumVsCountMap.get(prefixSum - k);
            }

            prefixSumVsCountMap.put(prefixSum, prefixSumVsCountMap.getOrDefault(prefixSum, 0) + 1);
        }

        return ansCount;
    }
}