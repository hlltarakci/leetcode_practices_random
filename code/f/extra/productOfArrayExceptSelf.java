// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    /*
        n: arr len
        time: O(n)
        space: O(1)
    */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        populateLeftProducts(nums, result);
        
        int rightProduct = 1;
        for(int i=nums.length-1; i>=0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }
    
    private void populateLeftProducts(int[] nums, int[] result) {
        result[0] = 1;
        for(int i=1; i<result.length; i++) 
            result[i] = result[i-1] * nums[i-1];
    }
}
