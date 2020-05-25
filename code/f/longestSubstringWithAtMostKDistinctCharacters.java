// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3017/

class Solution {
    /*
        n: s len
        time: O(n)
        space: O(k)
    */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0 || s.length() == 0) return 0;
        
        int max = 0;
        int start = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) { 
                if(map.size() == k) {
                    max = Math.max(max, i-start);
                    Map.Entry<Character,Integer> toRemove =  map.entrySet().iterator().next();
                    start = toRemove.getValue()+ 1;
                    map.remove(toRemove.getKey());
                }
            }
            map.remove(c);
            map.put(c, i);
        }
        
        max = Math.max(max, s.length()-start);
        
        return max;
    }
}
