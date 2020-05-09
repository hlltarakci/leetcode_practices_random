class Solution {
    /**
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        n: num of prices
        time: O(n)
        space: O(1)
    */
    public int maxProfit(int[] prices) {
        int maxProfitSoFar = 0;
        int minSoFar = Integer.MAX_VALUE;
        
        for(int price: prices) {
            if(price > minSoFar) maxProfitSoFar = Math.max(maxProfitSoFar, price - minSoFar);
            
            minSoFar = Math.min(minSoFar, price);
        }
        
        return maxProfitSoFar;
    }
}
