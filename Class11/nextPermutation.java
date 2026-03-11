class Solution {

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int beg, int en){
        while(beg <= en){
            swap(nums, beg, en);
            beg++;
            en--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;

        while(i >= 0){
            if(nums[i] < nums[i+1]){
                // peak found at i+1 -> replace ith element with just greater element present on the right side 
                break;
            }

            i--;
        }

        if(i == -1){
            // no peak present -> last permutation case 
            reverse(nums, 0, n-1);
            return;
        }

        int k = n-1;
        while(k > i){
            if(nums[i] < nums[k]){
                swap(nums, i, k);
                reverse(nums, i+1, n-1);
                break;
            }
            k--;
        }
    }
}