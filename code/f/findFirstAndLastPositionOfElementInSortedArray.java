// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/3030/

class Solution {
    /*
        n: array length
        time: O(log n)
        space: O(1)
    */
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        if(nums == null) return range;
        
        int left = findRange(nums, target, true);
        if(left == nums.length || nums[left] != target) return range;
        
        range[0] = left;
        range[1] = findRange(nums, target, false)-1;
        
        return range;
    }
    
    private int findRange(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right-left)/2;
            
            if(nums[mid] > target || (isLeft && nums[mid] == target)) right = mid;
            else left = mid+1;
        }
        
        return left;
    }
}
