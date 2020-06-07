// https://leetcode.com/explore/interview/card/facebook/57/others-3/3041/

class Solution {
    /*
        a: alphabet size (26)
        time: O(s1 + a*(s2-s1))
        space: O(a)
    */
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] refMap = new int[26];
        int[] map = new int[26];
        
        for(char ch: s1.toCharArray()) refMap[ch-'a']++;
        for(int i=0; i<s1.length(); i++) map[s2.charAt(i)-'a']++;
        
        if(isMatch(refMap, Arrays.copyOf(map, map.length))) return true;
        
        for(int i=s1.length(); i< s2.length(); i++) {
            map[s2.charAt(i-s1.length()) - 'a']--;
            map[s2.charAt(i) - 'a']++;
            if(isMatch(refMap, Arrays.copyOf(map, map.length))) return true;
        }
        
        return false;
    }
    
    private boolean isMatch(int[] refMap, int[] map) {
        for(int i=0; i<refMap.length; i++) {
            if(refMap[i] != map[i]) return false;
        }
        
        return true;
    }
}
