// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push(i);
            else if(c == ')') {
                if(stack.isEmpty()) indexesToRemove.add(i);
                else stack.pop();
            }
        }
        
        while(!stack.isEmpty()) indexesToRemove.add(stack.pop());
        
        return generateStr(s, indexesToRemove);
    }
    
    private String generateStr(String s, Set<Integer> indexesToRemove) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(!indexesToRemove.contains(i)) sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
