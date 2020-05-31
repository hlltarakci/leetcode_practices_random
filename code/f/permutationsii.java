// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/293/

class Solution {
    /*
        n: array len
        time: O(n n!) --> n! permutations each taking O(n) time 
        space: O(n n!) --> n! permutations each using n elements
        n n! migh be reducing to n! ?
    */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(results, nums, new ArrayList<>(), new boolean[nums.length]);
        return results;
    }
    
    private void backtrack(
        List<List<Integer>> results,
        int[] nums,
        List<Integer> result,
        boolean[] used) {
        if(result.size() == nums.length) {
            results.add(new ArrayList<>(result));
        } else {
            for(int i=0; i<nums.length; i++) {
                if(used[i] || i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue; 
                result.add(nums[i]);
                used[i] = true;
                backtrack(results, nums, result, used);
                result.remove(result.size()-1);
                used[i] = false;
            }
        }
    }
}
