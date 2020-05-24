// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/283/

class Solution {
    /*
        n: array len
        time: O(n^2) -- sort is n log n + looping n^2
        space: O(1) -- excluding space for output
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            
            int target = 0 - nums[i];
            int left = i+1, right = nums.length-1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if( sum == target) {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } 
                else if(sum < target) left++;
                else right--;
            }
        }
        
        return new ArrayList<>(results);
    }
}
