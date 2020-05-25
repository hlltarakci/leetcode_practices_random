// https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/310/

class Solution {
    /*
        n: interval count
        time: O(n log n) -- sort time included, alg is one loop O(n)
        space: O(n)
    */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        
        for(int[] interval: intervals) {
            if(merged.size() == 0) merged.add(interval);
            else {
                int[] lastInterval = merged.get(merged.size()-1);
                if(interval[0] <= lastInterval[1]) {
                    lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                } else {
                    merged.add(interval);
                }
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
