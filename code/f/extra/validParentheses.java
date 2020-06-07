// https://leetcode.com/problems/valid-parentheses/

class Solution {
    /*
        s: str len
        time: O(s)
        space: O(n)
    */
    public boolean isValid(String s) {
        if(s == null) return true;
        
        String openPar = "{[(";
        String closePar = "}])";
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()) {
            if(openPar.indexOf(c) >= 0) stack.push(c);
            else if(closePar.indexOf(c) >= 0) {
                if(stack.isEmpty()) return false;
                
                char matchC = stack.pop();
                if(openPar.indexOf(matchC) != closePar.indexOf(c)) return false;
            }
            
        }
        
        return stack.isEmpty();
    }
}
