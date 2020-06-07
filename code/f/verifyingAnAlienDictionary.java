// https://leetcode.com/explore/interview/card/facebook/57/others-3/3042/

class Solution {
    /*
        c: total content of words alltogether
        time: O(c)
        space: O(1)
    */
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=1; i<words.length; i++) {
            if(!before(words[i-1], words[i], order)) return false;
        }
        
        return true;
    }
    
    private boolean before(String prevWord, String currWord, String order) {
        if(prevWord.length() > currWord.length() && prevWord.startsWith(currWord)) return false;
        
        int len = Math.min(prevWord.length(), currWord.length());
        for(int i=0; i<len; i++) {
            int prevCh = order.indexOf(prevWord.charAt(i));
            int currCh = order.indexOf(currWord.charAt(i));
            
            if(prevCh > currCh) return false;
            else if(prevCh < currCh) return true;
        }
        
        return true;
    }
}
