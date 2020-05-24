// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3011/

class Solution {
    /*
        n: array len
        time: O(n)
        space: O(1)
    */
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        
        int realIndex = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[realIndex]) continue;
            
            nums[++realIndex] = nums[i];
        }
        
        return realIndex + 1;
    }
}
