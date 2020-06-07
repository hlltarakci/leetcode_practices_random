// https://leetcode.com/problems/valid-palindrome/

class Solution {
    /*
        n: str len
        time: O(n)
        space: O(1)
    */
    public boolean isPalindrome(String s) {
        int left=0, right = s.length()-1;
        while(left < right) {
            char charL = s.charAt(left);
            char charR = s.charAt(right);
            
            if(!Character.isLetterOrDigit(charL)) {
                left++;
                continue;
            }
            
            if(!Character.isLetterOrDigit(charR)) {
                right--;
                continue;
            }
            
            if(Character.toLowerCase(charL) != Character.toLowerCase(charR)) return false;
            left++;
            right--;
        }
        
        return true;
    }
}
