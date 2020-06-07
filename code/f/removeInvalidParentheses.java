// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/324/

class Solution {
    /*
        https://leetcode.com/problems/remove-invalid-parentheses/discuss/669014/JAVA-BFS
    */
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        set.add(s);
        while(!queue.isEmpty()) {
            if(results.size() > 0) break;
            
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String curr = queue.remove();
                if(isValid(curr)) results.add(curr);
                else {
                    for(int j=0; j<curr.length(); j++) {
                        char ch = curr.charAt(j);
                        if(ch == '(' || ch == ')') {
                            String newStr = curr.substring(0,j) + curr.substring(j+1, curr.length());
                            if(!set.contains(newStr)) {
                                queue.add(newStr);
                                set.add(newStr);
                            }
                        }
                    }
                }
            }
        }
        
        return results;
    }
    
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch: s.toCharArray()) {
            if(ch == '(') stack.push(ch);
            else if(ch == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
