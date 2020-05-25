// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/272/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    /*
        time: O(log n)
        space: O(log n) -- recursion stack
    */
    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }
    
    private int firstBadVersion(int left, int right) {
        if(left == right) return left;
        int mid = left + (right-left)/2;
        if(!isBadVersion(mid)) return firstBadVersion(mid+1, right);
        else return firstBadVersion(left, mid);
    }
}
