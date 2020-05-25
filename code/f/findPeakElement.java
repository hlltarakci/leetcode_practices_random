// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/3032/

class Solution {
    /*
        n: array len
        time: O(log n)
        space: O(log n) -- recursion stack
    */
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }
    
    private int findPeakElement(int[] nums, int left, int right) {
        if(left == right) return left;
        
        int mid = left + (right-left) / 2;
        int prev = mid == 0 ? Integer.MIN_VALUE : nums[mid-1];
        int next = mid == nums.length-1 ? Integer.MIN_VALUE : nums[mid+1];
        
        if(nums[mid] > prev && nums[mid] > next) return mid;
        if(prev > nums[mid]) return  findPeakElement(nums, left, mid-1);
        return findPeakElement(nums, mid+1, right);
    }
} 
