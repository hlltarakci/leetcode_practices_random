// https://leetcode.com/problems/target-sum/

class Solution {
    /*
        n: arr len
        time: O(2^n)
        space: O(n)
    */
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0);
    }
    
    private int findTargetSumWays(int[] nums, int S, int left) {
        if(left == nums.length) return  S == 0 ? 1 : 0;
        
        int minusOption = findTargetSumWays(nums, S+nums[left], left+1);
        int plusOption = findTargetSumWays(nums, S-nums[left], left+1);
        
        return minusOption + plusOption;
    }
}
