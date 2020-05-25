// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

class Solution {
    public int minAddToMakeValid(String S) {
        if(S.length() == 0) return 0;
        int count = 0;
        int openParCount = 0;
        for(char c: S.toCharArray()) {
            if(c == '(') openParCount++;
            else if(c == ')') {
                if(openParCount == 0) count++;
                else openParCount--;
            }
        }
        
        count += openParCount;
        
        return count;
    }
}
