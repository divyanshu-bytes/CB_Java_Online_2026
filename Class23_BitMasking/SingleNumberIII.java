class Solution {
    public int[] singleNumber(int[] nums) {
        int xorr = 0;
        for(int el: nums){
            xorr = xorr ^ el;
        }

        // xorr -> contains 2 unique nos
        // extract both nos from xorr

        // xorr -> find out the index of the right most set bit -> k
        // form 2 category of numbers, based on whether kth bit is set or unset

        // M-1
        int temp = xorr;
        int k = 0;
        while(temp != 0){
            if((temp & 1) != 0){
                break;
            }
            k++;
            temp = temp>>1;
        }

        int mask = (1 << k);

        // M-2
        // int mask = (xorr & (xorr-1)) ^ xorr;

        int categoryA_XOR = 0;
        int categoryB_XOR = 0;

        for(int el: nums){
            if((el & mask) != 0){
                categoryA_XOR = categoryA_XOR ^ el;
            }
            else{
                categoryB_XOR = categoryB_XOR ^ el;
            }
        }

        return new int[]{categoryA_XOR, categoryB_XOR};
    }
}