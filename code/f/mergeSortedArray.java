// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/309/

class Solution {
    /*
        time: O(m+n)
        space: O(1)
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, i1 = m-1, i2 = n-1;
        while(index >= 0) {
            int val1 = i1 >= 0 ? nums1[i1] : Integer.MIN_VALUE;
            int val2 = i2 >= 0 ? nums2[i2] : Integer.MIN_VALUE;
            
            if(val1 > val2) {
                nums1[index--] = val1;
                i1--;
            } else {
                nums1[index--] = val2;
                i2--;
            }
        }
        
    }
}
