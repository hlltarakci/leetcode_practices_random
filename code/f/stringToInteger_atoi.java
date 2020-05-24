// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3009/

class Solution {
    /*
        n: str len
        time: O(n)
        space: O(1)
    */
    public int myAtoi(String str) {
        long val = 0;
        
        char[] chars = str.toCharArray();
        int index = 0;
        
        // discard whitespaces
        while(index < chars.length && chars[index] == ' ') index++;
        
        // optional plus or minus
        boolean isNeg = false;
        if(index < chars.length && chars[index] == '-') {
            isNeg = true;
            index++;
        } else if(index < chars.length && chars[index] == '+') index++;
        
        // digits = numerical value
        while(index < chars.length && Character.isDigit(chars[index])) {
            val = 10L * val +  Character.getNumericValue(chars[index]);
            // if over/underflows, return max/min
            if(isNeg && (-val) < Integer.MIN_VALUE ) return Integer.MIN_VALUE;
            if(!isNeg && val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            index++;
        }
        
        // rest ignored
        
        return isNeg ? -(int)val : (int)val ;
    }
}
