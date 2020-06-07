// https://leetcode.com/problems/combination-sum/

class Solution {
    /*
        ?
        n: array len
        k: average len of each combination
        m: average combination count
        time: O(n m)
        space: O(m k)
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, candidates, target, 0, new ArrayList<>());
        return results;
    }
    
    private void backtrack(
        List<List<Integer>> results,
        int[] candidates, 
        int target,
        int curr,
        List<Integer> result) {
        if(target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        
        if(target < 0) return;
        for(int i=curr; i<candidates.length; i++) {
            result.add(candidates[i]);
            backtrack(results, candidates, target - candidates[i], i, result);
            result.remove(result.size()-1);
        }
    }
        
}
