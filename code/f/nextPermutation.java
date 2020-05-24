// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3012/

class Solution {
    /*
        n: array len
        t: O(n)
        space: O(1)
    */
    public void nextPermutation(int[] nums) {    
        if(nums.length < 2) return;
        
        for(int i = nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                swap(nums, i, largerElemIndex(nums, i));
                reverse(nums, i+1);
                return;
            }
        }
        
        reverse(nums, 0);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private int largerElemIndex(int[] nums, int index) {
        int larger = -1;
        for(int i=index+1; i<nums.length; i++ ) {
            if(nums[index] < nums[i]) larger = larger < 0 || nums[larger] >= nums[i] ? i : larger ;
        }
        
        return larger;
    }
    
    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length-1;
        while(left < right) swap(nums, left++, right--);
    }
}
