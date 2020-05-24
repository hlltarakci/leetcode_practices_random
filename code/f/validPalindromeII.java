// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/289/

class Solution {
    /*
        n: str len
        time:O(n)
        space: O(1)
    */
    int errorChance = 1;
        
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        
        while(left < right) {
            char leftC = s.charAt(left);
            char rightC = s.charAt(right);
            
            if(leftC != rightC) {
                if(errorChance <= 0) return false;
                errorChance--;
                
                return validPalindrome(s.substring(left+1, right+1)) ||
                       validPalindrome(s.substring(left, right));
            }
            
            left++;
            right--;
            
        }
        
        return true;
    }
}
