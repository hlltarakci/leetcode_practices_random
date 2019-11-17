// Approach 1

class Solution {
    /*
        https://leetcode.com/problems/frog-jump/
        
        approach: brute force - backtracking
        time limit exceeded
        
        n: num of stones
        time complexity: O(3^n) ?
        space complexity: O(n) -- recusion 
        
        a simple optimization is using a memo table for index-jump size pair-- 
        this will reduce time complexity to O(n^2 log n) -- this is so instead of n^3, since below alg uses binary search 
        space complexity will be increased to O(n^2) because of the memo table
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

// Approach 2

class Solution {
    /*
        https://leetcode.com/problems/frog-jump/
        DP -- leetcode's solution
        
        keep a map: 
            key: value of stone
            value: what are the jump sizes that could get me here
            
        n: number of stones
        time: O(n^2) -- two nested loops
        space: O(n^2) -- hashmap can grow that much
    */
    public boolean canCross(int[] stones) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        
        // init map
        for(int stone: stones) map.put(stone, new HashSet<Integer>());
        
        // first stone's jump size is 0 by definition
        map.get(stones[0]).add(0);
        
        // iterate through stones
        for(int i=0; i<stones.length; i++) {
            // retrieve jump sizes for that stone
            for(int jumpSize: map.get(stones[i])) {
                // loop for possible next jump sizes
                for(int k = jumpSize-1; k <= jumpSize+1; k++) {
                    // if jump size is 0, no need to check
                    if(k == 0) continue;
                    // if there is a stone at that jump away, than can go forward
                    int nextIndex = stones[i]+k;
                    if(map.containsKey(nextIndex))  map.get(nextIndex).add(k);
                }
            }
        }
        
        // if last stone has some jumpSizes in it, frog can go there
        return map.get(stones[stones.length-1]).size() > 0;
    }
}
