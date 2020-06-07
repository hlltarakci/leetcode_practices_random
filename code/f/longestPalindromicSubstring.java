// https://leetcode.com/explore/interview/card/facebook/55/dynamic-programming-3/3034/

class Solution {
    /*
        n: str len
        time:O(n^2) -- O(n) for exand, O(n) for looping
        space: O(1)
    */
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()) return "";
        int start=0, end=0;
        for(int i=0; i<s.length(); i++) {
            int len = Math.max(expand(s, i, i), expand(s, i, i+1));
            if(len > (end-start)) {
                end = i + (len/2);
                start = i - ( (len-1)/2);
            }
        }
        
        return s.substring(start, end+1);
    }
    
    private int expand(String s, int left, int right) {
        while(left <= right) {
            if(left < 0 || right >= s.length()) break;
            if(s.charAt(left) != s.charAt(right)) break;
            left--;
            right++;
        }
        
        return right-left-1;
    }
}
