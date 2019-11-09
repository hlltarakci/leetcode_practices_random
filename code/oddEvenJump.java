class Solution {
    /*
        https://leetcode.com/problems/odd-even-jump/
    */
    public int oddEvenJumps(int[] A) {
        // last index is there for sure
        // and we know that we don't get empty array
        int countOfGoodIndexes = 1; 
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[] odds = new boolean[A.length];
        boolean[] evens = new boolean[A.length];
        
        odds[A.length-1] = true;
        evens[A.length-1] = true;
        map.put(A[A.length-1], A.length-1);
        
        for(int i=A.length-2; i >= 0; i--) {
            // odds case
            Integer nextJump = getNextJump(map, A[i], false);
            if(nextJump != null) {
                if(evens[map.get(nextJump)])  {
                    odds[i] = true;
                    countOfGoodIndexes++;
                }
            }
            
            // evens case
            nextJump = getNextJump(map, A[i], true);
            if(nextJump != null) {
                if(odds[map.get(nextJump)]) evens[i] = true;
            }
            
            map.put(A[i], i);
        }
        
        return countOfGoodIndexes;
    }
    
    private Integer getNextJump(TreeMap<Integer, Integer> map, int value, boolean isForEvens) {
        return isForEvens ? map.floorKey(value) : map.ceilingKey(value);
    }
}
