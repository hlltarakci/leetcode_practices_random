// https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1, high = Integer.MAX_VALUE;
        
        while(low < high) {
            int mid = low + (high-low) / 2;
            if(!canEatAll(piles, H, mid)) low = mid+1;
            else high = mid;
        }
        
        return low;
    }
    
    private boolean canEatAll(int[] piles, int H, int K) {
        int hours = 0;
        for(int pile: piles) {
            hours += pile / K;
            if(pile % K > 0) hours++;
        }
        return hours <= H;
    }
}
