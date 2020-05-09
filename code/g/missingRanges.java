class Solution {
    /*
        https://leetcode.com/problems/missing-ranges/
        
        n: array size
        time: O(n)
        space: O(1)
        
        ! Overflow case is important..
        Can use Long to prevent Int overflow.
    */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missingRanges = new ArrayList<>();
        
        long lLower = (long) lower;
        for(int num: nums) {
            addIfMissingRange(missingRanges, lLower, num);
            lLower = (long)num+1;
        }
        
        addIfMissingRange(missingRanges, lLower, (long)upper+1);
        
        return missingRanges;
    }
    
    // use long, so do not deal with overflow
    private void addIfMissingRange(List<String> missingRanges, long lower, long num) {
        String missing = checkMissingBetween(lower, num);
        if(!missing.isEmpty()) missingRanges.add(missing);
    }
    
    private String checkMissingBetween(long lower, long num) {
        StringBuilder missing = new StringBuilder();
        
        if(num > lower)  {
            if( num - lower == 1) missing.append(lower);
            else missing.append(lower).append("->").append(num-1);
        }
        
        return missing.toString();
    }
}
