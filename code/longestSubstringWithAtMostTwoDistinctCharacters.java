class Solution {
    /*
        https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
        
        n: string length
        time: O(n) -- one pass sliding window
        space: O(1) -- hashmap always has <= 3 elements
        
        sliding window
    */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // corner case
        if(s.length() < 3) return s.length();  
        
        int max = 0;
        int left = 0, right = 0;
        
        // always be with size <= 2
        Map<Character, Integer> seenMap = new HashMap<>(); 
        
        while(right < s.length()) {
            char c = s.charAt(right);
            // still seeing same two chars, extend window
            // OR a new char seen, but still have not seen two chars yet, so still extend window
            if(seenMap.containsKey(c) || seenMap.size() < 2) {
                max = Math.max(max, (right-left + 1));
                
                // update last seen index
                seenMap.put(c, right);
                
                // extend window
                right++;
            }
            
            // more than two chars seen, narrow window
            else {
                int indexOfCharToRemove = Collections.min(seenMap.values());
                System.out.println(indexOfCharToRemove);
                seenMap.remove(s.charAt(indexOfCharToRemove));
                left = indexOfCharToRemove + 1;   
                
                // update last seen index
                seenMap.put(c, right);
            }
            
            
        }
        
        return max;
    }
}
