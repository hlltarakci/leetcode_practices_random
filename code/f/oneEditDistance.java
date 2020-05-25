// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3015/

class Solution {
    /*
        m, n: str lens
        time: O(max(m, n))
        space: O(1)
    */
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(Math.abs(sLen - tLen) > 1) return false;
        
        if(sLen == tLen) return isOneReplaceDistance(s, t);
        if(sLen > tLen) return isOneInsertDistance(s, t);
        return isOneInsertDistance(t, s);
    }
    
    private boolean isOneInsertDistance(String longer, String shorter) {
        boolean diffSeen = false;
        int indexLong = 0, indexShort = 0;
        while(indexLong < longer.length() && indexShort < shorter.length()) {
            if(longer.charAt(indexLong) != shorter.charAt(indexShort)) {
                if(diffSeen) return false;
                
                diffSeen = true;
                indexLong++;
            } else {
                indexLong++;
                indexShort++;
            }
        }
        
        return true;
    }
    
    private boolean isOneReplaceDistance(String s, String t) {
        boolean diffSeen = false;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(diffSeen) return false;
                
                diffSeen = true;
            }
        }
        
        return diffSeen;
    }
}
