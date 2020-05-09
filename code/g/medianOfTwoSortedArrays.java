class Solution {
    /*
        https://leetcode.com/problems/median-of-two-sorted-arrays/
        
        if lists follow each other, 
        median can be found easily by considering them as one big list
        
        bruteforce: simulate their merge and based on the element count, 
        return in the middle, when you hit the median -- time O(n+m)
        
        find two medians:
        approach explained here: https://www.youtube.com/watch?v=LPFhl65R7ww
        
        the idea is: take smaller array and binary Search on that
        thus time complexity becomes O(log (min(m,n))) where m and n are array sizes
        
        find middle of smaller array
        calculate half of the elements, but make sure if odd, extra element remains in left
        
        based on how many elements are before mid in smaller array, 
        remaining elements should come from the other array
        
        check if right of smaller array greater than left of bigger array &&
                 right of bigger array greater than left of smaller array
        if this is the case - they are the elements to calc median
            if even --> take max of left sides and min of right sides and average them
            else --> take max of left side (we made sure extra element is in left above)
            
        
        else if min of right side of smaller array smaller than min of left side of bigger array
        --> go left
        
        else
        --> go right
        
        m, n: array sizes
        time: O(log(min(m,n)))
        space: O(1)
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        // make sure first argument is smaller array
        // to ensure algorithm complexity stays O(log (min(m,n)))
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int totalNumOfElements = nums1.length + nums2.length;
        
        // if odd, extra element should stay in left side
        int leftNumOfElements = (totalNumOfElements+1) / 2;
        
        int left1 = 0, right1 = nums1.length;
        
        // calc mids and check 
        while(left1 <= right1) {
            int mid1 = left1 + (right1-left1) / 2;
            int mid2 = leftNumOfElements - mid1;
            
            int minOfRight1 = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE;
            int minOfRight2 = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;
            int maxOfLeft1 = mid1 > 0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int maxOfLeft2 = mid2 > 0 ? nums2[mid2-1] : Integer.MIN_VALUE;
        
            // we found median
            if(minOfRight1 >= maxOfLeft2 && minOfRight2 >= maxOfLeft1 ) {
                // even case
                if(totalNumOfElements % 2 == 0) 
                    median = (double)( Math.max(maxOfLeft1, maxOfLeft2) + 
                             Math.min(minOfRight1, minOfRight2) ) / 2;
                
                // odd case -- we made sure extra is at left side
                else median = (double) Math.max(maxOfLeft1, maxOfLeft2);
                
                // found it, break the loop
                break;
            }
            
            // if min of right of smaller array is less than max of left of bigger array
            // we sould go forward in smaller array
            if(minOfRight1 <= maxOfLeft2 ) left1 = mid1 + 1;
            
            // else, we should go backwards in smaller array
            else right1 = mid1 - 1 ;
        } 
        
        return median;
        
    }
}
