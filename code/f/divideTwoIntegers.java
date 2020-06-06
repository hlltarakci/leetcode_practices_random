// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/308/

class Solution {
    /*
        https://leetcode.com/articles/divide-integers/
        n: abs(dividend)
        time: O(log n)
        space: O(1)
    */
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        int halfmin = -(int)Math.pow(2, 30);
        System.out.println(halfmin);
        
        int negatives = 2;
        if(dividend > 0) {
            negatives--;
            dividend = -dividend; 
        }
        if(divisor > 0) {
            negatives--;
            divisor = -divisor;
        }
        
        int highestDouble = divisor;
        int highestPowerOfTwo = 1;
        while(highestDouble >= halfmin && highestDouble + highestDouble >= dividend) {
            highestDouble += highestDouble;
            highestPowerOfTwo += highestPowerOfTwo;
        }
        
        int result = 0;
        while(dividend <= divisor) {
            if(dividend <= highestDouble) {
                result += highestPowerOfTwo;
                dividend -= highestDouble;
            }
            
            highestDouble >>= 1;
            highestPowerOfTwo >>= 1;
        }
        
        return negatives == 1 ? -result : result;
    }
}
