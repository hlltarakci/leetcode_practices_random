// https://leetcode.com/explore/interview/card/facebook/55/dynamic-programming-3/3036/

class Solution {
    /*
        n: str len
        time: O(n^2)
        space: O(n)
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    
    private boolean backtrack(String s, Set<String> wordDict, int curr, Boolean[] memo) {
        if(curr == s.length()) return true;
        
        if(memo[curr] != null) return memo[curr];
        
        int i=curr+1;
        while(i <= s.length()) {
            if(wordDict.contains(s.substring(curr, i)) && backtrack(s, wordDict, i, memo)) {
                memo[curr] = true;
                return true;
            }
            i++;
        }
        
        memo[curr] = false;
        return false;
    }
}
