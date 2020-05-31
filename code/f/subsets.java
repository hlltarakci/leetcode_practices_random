// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/278/

class Solution {
    /*
        n: array length
        time: O(n 2^n) -- there are 2^n elements in result set, each call spends O(n) time
        space: O(n 2^n) -- there are 2^n subsets and each subset has elements up to n
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, nums, 0, new ArrayList<>());
        return results;
    }
    
    private void backtrack(
        List<List<Integer>> results, 
        int[] nums,
        int curr,
        List<Integer> result) {
        
        results.add(new ArrayList<>(result));
        
        for(int i=curr; i<nums.length; i++) {
            result.add(nums[i]);
            backtrack(results, nums, i+1, result);
            result.remove(result.size()-1);
        }
    }
}
