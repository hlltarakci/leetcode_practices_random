class Solution {
    /*
        n: len of str
        time: O(n)
        space: O(n)
    */
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        int startIndex = 0, max = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= startIndex ) {
                max = Math.max(max, i - startIndex);
                startIndex = map.get(c) + 1;   
            }
            map.put(c, i);
        }
        
        max = Math.max(max, s.length() - startIndex);
        
        return max;
    }
}
