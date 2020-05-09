class Solution {
    /*
     https://leetcode.com/problems/split-array-largest-sum/
     binary search + greedy
     
     left: max element in array
     right: sum
     mid = left + (right-left)2
     
     divide to sums <= mid --> how many divisions?
        if >= m, this means we divided further, sum is too small - increase left = mid+1
        else, maybe we can do better, right = mid
     
     n: array size
     sum: sum of array --> binary search depends on this
     time: O(n log sum)
     space: O(1) -- excluding input space
    */
    public int splitArray(int[] nums, int m) {
        long left = 0, right = 0;
        for(int num: nums) {
            left = Math.max((long)num, left);
            right += num;
        }
        
        long maxDivisionSum = 0;
        while(left <= right) {
            long mid = left + (right-left) / 2;
            int numOfDivisions = 0;
            long currentSum = 0;
            maxDivisionSum = 0;
            for(int num: nums) {
                if(currentSum + num > mid) {
                    numOfDivisions++;
                    maxDivisionSum = Math.max(maxDivisionSum, currentSum);
                    currentSum = num;
                } else currentSum += num;
            }
            maxDivisionSum = Math.max(maxDivisionSum, currentSum);
            if(currentSum > 0) numOfDivisions++;
            
            if(left == right) break;
            
            if(numOfDivisions > m) left = mid + 1;
            else right = mid;
        }
        
        return (int)maxDivisionSum;
    }
}
