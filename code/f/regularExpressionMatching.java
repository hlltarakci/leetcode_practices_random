// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/307/

class Solution {
    /* 
        https://leetcode.com/articles/regular-expression-matching/#
        time: O(s p)
        space: O(s p)
    */
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        
        for(int i=s.length(); i>=0; i--) {
            for(int j=p.length()-1; j>=0; j--) {
                boolean isFirstMatch = i < s.length() &&
                          (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                
                if( j != p.length()-1 && p.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] ||
                               isFirstMatch && dp[i+1][j];
                } else {
                    dp[i][j] = isFirstMatch && dp[i+1][j+1];
                }
            }
        }
        
        return dp[0][0];
    }
}



/* approach: recursion
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        
        boolean isFirstMatch = !s.isEmpty() && 
            (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || 
                   isFirstMatch && isMatch(s.substring(1), p); 
        } 
        
        return isFirstMatch && isMatch(s.substring(1), p.substring(1));
    }
}
*/
