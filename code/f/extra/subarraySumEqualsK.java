// https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    /*
        n: arr len
        time: O(n^2)
        space: O(1)
    */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        for(int start = 0; start<nums.length; start++) {
            int sum = 0;
            for(int end = start; end<nums.length; end++) {
                sum += nums[end];
                if(sum == k) count++;
            }
        }
        
        return count;
    }
}
