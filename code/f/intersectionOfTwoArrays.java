// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/3033/

class Solution {
    /*
        n, m: array lens
        time: O(n+m)
        space: O(n+m) -- set usages
    */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num: nums1) set1.add(num);
        
        Set<Integer> set2 = new HashSet<>();
        for(int num: nums2) set2.add(num);
        
        set1.retainAll(set2);
        
        return toArray(set1);
    }
    
    private int[] toArray(Set<Integer> set) {
        int[] arr = new int[set.size()];
        int index = 0;
        for(int num: set) arr[index++] = num;
        return arr;
    }
}
