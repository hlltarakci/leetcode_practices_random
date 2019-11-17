class Solution {
    /*
        https://leetcode.com/problems/frog-jump/
        
        approach: brute force - backtracking
        time limit exceeded
        
        n: num of stones
        time complexity: O(3^n) ?
        space complexity: O(n) -- recusion 
        
    */
    public boolean canCross(int[] stones) {
        return backtrack(stones, 0, 0);
    }
    
    private boolean backtrack(int[] stones, int atIndex, int k) {
        // goal: reaching at last stone = crossing the river
        if(atIndex == stones.length -1) return true;
        
        // choice: i can jump to k-1, k or k+1 if these are valid
        for(int i=k-1; i<= k+1; i++) {
            // check if we can go i
            int nextIndex = jumpToIndex(stones, atIndex, i);
            if( nextIndex >= 0) {
                boolean isArrived = backtrack(stones, nextIndex, i);
                // if already at the end, we are done
                if(isArrived) return true;
            }
        }
        
        // we tried everything, but cannot get a return true so far
        return false;
    }
    
    private int jumpToIndex(int[] stones, int atIndex, int k) {
        int nextIndex = Arrays.binarySearch(stones, stones[atIndex] + k);
        return nextIndex > atIndex ? nextIndex : -1;
    }
}
