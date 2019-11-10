// approach 1
class Solution {
    /*
        https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
        
        n: string length
        Time: O(n log k) -- log k for getting most distant index from min heap
        Space: O(k) -- hashmap and min heap usages
        
        best case: when there is less than k distinct chars - then O(n)
        worst case: when there is n distinct chars
        
        sliding windows + hashmap + min heap
    */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        // corner case
        if(s.isEmpty() || k < 1) return 0;
        
        int max = 0, count = 0;
        
        PriorityQueue<Integer> lastSeenIndexes = new PriorityQueue<>();
        Map<Character, Integer> lastSeenChars = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            // check if this char has seen before
            if(lastSeenChars.containsKey(c)) {
                // update lastSeen
                lastSeenIndexes.remove(lastSeenChars.get(c));
                lastSeenIndexes.add(i);
                
                lastSeenChars.put(c, i);
            }
            // check if not seen k chars yet
            else if(lastSeenChars.size() < k) {
                lastSeenChars.put(c, i);
                lastSeenIndexes.add(i);
            } 
            // a new char seen over k chars, update lastSeen
            else {
                int indexOfMostDistantLastSeen = lastSeenIndexes.remove();
                char charToRemove = s.charAt(indexOfMostDistantLastSeen);
                lastSeenChars.remove(charToRemove);
                
                count = i - indexOfMostDistantLastSeen -1;
                
                lastSeenChars.put(c, i);
                lastSeenIndexes.add(i);
            }
            
            // in each case, update count and adjust max
            count++;
            max = Math.max(max, count);
        }
        
        return max;
    }
}

// approach 2:
class Solution {
    /*
        https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
        
        n: string length
        Time: O(n) 
        Space: O(k) -- hashmap
        
        sliding windows + linked hashmap
        ! linked hashmap iterates based on insertion order, so re-insert, do not update
    */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        // corner case
        if(s.isEmpty() || k < 1) return 0;
        
        int max = 0, count = 0;
        
        LinkedHashMap<Character, Integer> lastSeenChars = new LinkedHashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            // check if this char has seen before or there are less distinct chars than k so far
            if(lastSeenChars.containsKey(c) || lastSeenChars.size() < k) {
                lastSeenChars.remove(c);
                lastSeenChars.put(c, i);
            } 
            // a new char seen over k chars
            else {
                Map.Entry<Character, Integer> entryOfMostDistantLastSeen = 
                    lastSeenChars.entrySet().iterator().next();
                count = i - entryOfMostDistantLastSeen.getValue() -1;
                lastSeenChars.remove(entryOfMostDistantLastSeen.getKey());
                lastSeenChars.put(c, i);
            }
            
            // in each case, update count and adjust max
            count++;
            max = Math.max(max, count);
        }
        
        return max;
    }
}
