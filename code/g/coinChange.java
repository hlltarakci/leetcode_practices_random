class Solution {
    /**
        https://leetcode.com/problems/coin-change/
        
        DP
        keep an array of size amount
            index: the amount
            value: min number of coins to make that amount
        
        fill the array from index 0 to amount (array[amount] is the answer)
        while considering index i:
            get min of:
                array[i-coin[j]] + 1  --> looping for coins
                
        time: O(amount*coins) -- nested loop
        space: O(amount) -- dp array
    */
    public int coinChange(int[] coins, int amount) {
        // corner case
        if(amount == 0) return 0;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        
        for(int currentAmount=1; currentAmount<=amount;currentAmount++) {
            for(int coin: coins) {
                // if coin is greater than the amount, it cannot be used
                if(currentAmount < coin) continue;
                
                // if coin is equal to the amount, than it is 1 already, min possible answer
                if(currentAmount == coin) {
                    dp[currentAmount] = 1;
                    continue;
                }
                
                // if remaining amount is valid, then check it
                // adding this coin to that value might be a candidate
                int remainingAmount = currentAmount - coin;
                if(remainingAmount > 0 && dp[remainingAmount] > 0)
                    dp[currentAmount] = dp[currentAmount] == -1 ? 
                        dp[remainingAmount] + 1 : Math.min(dp[currentAmount],  dp[remainingAmount] + 1);
            }
        }
        
        return dp[amount];
    }
}
