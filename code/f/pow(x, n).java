// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/3031/

class Solution {
    /*
        time: O(log n)
        space: O(log n)
    */
    public double myPow(double x, int n) {
         if(n < 0) {
            x = 1/x;
            n = -n;
        }
        return fastPow(x, (long)n);
    }
    
    private double fastPow(double x, long n) {
        if(n == 0) return 1;
       
        double half = fastPow(x, n/2);
        
        if(n % 2 == 0) return half * half;
        
        return half*half*x;
    }
}
