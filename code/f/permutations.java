// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/292/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, nums, new HashSet<>(), new ArrayList<>());
        return results;
    }
    
    private void backtrack(List<List<Integer>> results, int[] nums, Set<Integer> set, List<Integer> result) {
        if(result.size() == nums.length) results.add(new ArrayList<>(result));
        
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) continue;
            
            set.add(nums[i]);
            result.add(nums[i]);
            backtrack(results, nums, set, result);
            result.remove(result.size()-1);
            set.remove(nums[i]);
        }
    }
}
