// https://leetcode.com/explore/interview/card/facebook/55/dynamic-programming-3/3035/

class Solution {
    /*
        n: str len
        time: O(n)
        space: O(1)
    */
    public int longestValidParentheses(String s) {
        int max = 0;
        int openPars = 0, closePars = 0;
        
        // left to right
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') openPars++;
            else if(s.charAt(i) == ')') {
                if(openPars == closePars) {
                    openPars = 0;
                    closePars = 0;
                } else closePars++;
            }
            
            if(openPars == closePars) max = Math.max(max, openPars+closePars);
        }
        
        openPars = 0;
        closePars = 0;
        
        // right to left
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == ')') closePars++;
            else if(s.charAt(i) == '(') {
                if(closePars == openPars) {
                    openPars = 0;
                    closePars = 0;
                } else openPars++;
            }
            
            if(openPars == closePars) max = Math.max(max, openPars+closePars);
        }
        
       
        return max;
    }
}
