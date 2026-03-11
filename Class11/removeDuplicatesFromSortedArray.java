class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i = 0, j = 0;
        int n = nums.length;

        while(i < n){
            if(i+1 < n && nums[i] == nums[i+1]){
                i++;
                continue;
            }

            nums[j] = nums[i];
            j++;
            i++;
        }

        return j;
    }
}