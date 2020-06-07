// https://leetcode.com/explore/interview/card/facebook/55/dynamic-programming-3/264/

class Solution {
    int count = 0;
    public int numDecodings(String s) {
        backtrack(s, 0);
        return count;
    }
    
    private void backtrack(String s, int curr) {
        if(curr == s.length()) {
            count++;
            return;
        }
        
        char ch = s.charAt(curr);
        if(ch != '0') backtrack(s, curr+1);
        
        if(curr != s.length()-1) {
            char nextCh = s.charAt(curr+1);
            if(ch == '1' && nextCh >= '0' && nextCh <= '9' ||
               ch == '2' && nextCh >= '0' && nextCh <= '6')
                backtrack(s, curr+2);
        }
    }
}
