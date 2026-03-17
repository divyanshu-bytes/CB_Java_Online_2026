class Solution {
    public int majorityElement(int[] nums) {
        int majElementPromisingCandidate = nums[0];
        int vote = 1;
        int n = nums.length;

        for(int i=1; i<n; i++){
            if(nums[i] == majElementPromisingCandidate){
                vote++;
            }
            else{
                vote--;
            }

            if(vote == 0){
                majElementPromisingCandidate = nums[i];
                vote = 1;
            }
        }

        // Confirm if majElementPromisingCandidate is the actual majorityElement or not, by calculating its count

        int count = 0;

        for(int el: nums){
            if(el == majElementPromisingCandidate){
                count++;
            }
        }   

        if(count > n/2){
            return majElementPromisingCandidate;
        }

        return -1;
    }
}