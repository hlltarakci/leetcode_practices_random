// https://leetcode.com/explore/interview/card/facebook/57/others-3/3043/

class Solution {
    /*
        time: O(a+b)
        space O(a+b)
    */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        
        int indexA=0, indexB=0;
        while(indexA < A.length && indexB < B.length) {
            int start = Math.max(A[indexA][0], B[indexB][0]);
            int end = Math.min(A[indexA][1], B[indexB][1]);
            
            if(start <= end) list.add(new int[] {start, end});
            
            if(A[indexA][1] < B[indexB][1]) indexA++;
            else indexB++;
        }
        
        
        return list.toArray(new int[list.size()][]);
    }
}
