// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/292/

class Solution {
    /*
        n: array len
        time: O(n n!) --> n! permutations with O(n) for each call
        space: O(n n!) --> n! permutations with n elements in each
        
        does n n! reduce to n! ?
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, nums, new ArrayList<>());
        return results;
    }
    
    private void backtrack(
        List<List<Integer>> results,
        int[] nums,
        List<Integer> result) {
        if(result.size() == nums.length) results.add(new ArrayList<>(result));
        else {
            for(int i=0; i<nums.length; i++) {
                if(result.contains(nums[i])) continue;
                result.add(nums[i]);
                backtrack(results, nums, result);
                result.remove(result.size()-1);
            }
        }
    }
}
