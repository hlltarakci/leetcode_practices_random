// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/267/

class Solution {
    /*
        n: digits with 3 chars
        m: digits with 4 chars
        time: O(3^n 4^m)
        space:  O(3^n 4^m)
    */
    
  char[][] values = { 
        {},
        {},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if(digits.length() == 0) return results;
        
        backtrack(results, digits, 0, new StringBuilder());
        return results;
    }
    
    private void backtrack(List<String> results, String digits, int curr, StringBuilder sb) {
        if(curr == digits.length() ) {
            results.add(sb.toString());
            return;
        }
        
        for(char val: values[Character.getNumericValue(digits.charAt(curr))]) {
            sb.append(val);
            backtrack(results, digits, curr+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}
