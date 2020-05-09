class Solution {
    /*
        https://leetcode.com/problems/backspace-string-compare/
        
        
        time: O(s + t)
        space: O(1)
        
        pay attention to loop indexes, easy to get into an infinite loop mistakenly
    */
    public boolean backspaceCompare(String S, String T) {
        int sIndex = S.length()-1, tIndex = T.length()-1;
        
        while(sIndex >= 0 || tIndex >= 0) {
            sIndex = getIndexOfPrintableChar(S, sIndex);
            tIndex = getIndexOfPrintableChar(T, tIndex);
            
            // printable chars done in both
            if(sIndex < 0 && tIndex < 0) return true;
            
            // printable chars done in only one of them
            if(sIndex < 0 || tIndex < 0) return false;
            
            // both have legit printable chars, so do compare
            if(S.charAt(sIndex) != T.charAt(tIndex) ) return false;
            
            sIndex--;
            tIndex--;
        }
        
        return true;
    }
    
    private int getIndexOfPrintableChar(String str, int index) {
        char backspace = '#';
        
        int deleteCount = 0;
        while(index >= 0) {
            char c = str.charAt(index);
            if( c == backspace) deleteCount++;
            else if( deleteCount == 0 ) return index;
            else deleteCount--;
            
            index--;
        }
        
        
        return -1;
    }
    
    
}
