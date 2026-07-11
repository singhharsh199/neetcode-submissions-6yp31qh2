class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < result.length; i++){
            result[i] = 1;
        }
        //[1,1,1,1]
        int prefixProduct = 1;
        for(int i = 0; i < nums.length; i++){
            result[i] = prefixProduct;
            prefixProduct = prefixProduct * nums[i];
        }
        //[1,2,8,32]
        int suffixProduct = 1;
        for(int i = result.length - 1; i >= 0; i--){
            result[i] = result[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }
        return result;
    }
}  
