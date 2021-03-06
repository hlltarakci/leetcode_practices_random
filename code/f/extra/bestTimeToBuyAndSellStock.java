// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    /*
        n: num of prices
        time: O(n)
        space: O(1)
    */
    public int maxProfit(int[] prices) {
        int max = 0, minSoFar = Integer.MAX_VALUE;
        
        for(int i=0; i<prices.length; i++) {
            int profit = prices[i] - minSoFar;
            max = Math.max(max, profit);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        
        return max;
    }
}

