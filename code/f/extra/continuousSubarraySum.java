// https://leetcode.com/problems/continuous-subarray-sum/

class Solution {
    /*
        time: O(n)
        space: O(min(n, k))
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(k != 0) sum = sum % k;
            if(map.containsKey(sum)) {
               if(i - map.get(sum) > 1) return true;
            } else map.put(sum, i);
        }
        
        return false;
    }
    
    /* approach: dp
    //    n: nums arr len
    //    time: O(n^2)
    //    space: O(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 0) return false;
        
        int[] dp = new int[nums.length];
        for(int i=1; i<nums.length; i++) dp[i] = dp[i-1] + nums[i];
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int sum = dp[j] - dp[i] + nums[i];
                if( sum == k ||
                    k != 0 && sum % k == 0) return true;
            }
        }
        
        return false;
    }
    */
}
