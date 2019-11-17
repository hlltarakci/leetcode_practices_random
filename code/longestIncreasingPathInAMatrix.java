// Approach 1

class Solution {
    /*
        https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
        Time Limit Exceeded
        Approach: Naive DFS 
        for each entry, examine 4-directions and check for increasing sequences
        
        observation: not necessary to check for cells
        that are already follower of a sequence
    */
    public int longestIncreasingPath(int[][] matrix) {
        int longestPathLength = 0;
        Set<String> seen = new HashSet<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(!seen.contains(getKey(i, j))) {
                   int len = dfs(matrix, i, j, seen);
                   longestPathLength = Math.max(longestPathLength, len);
                }
            }
        }
        
        return longestPathLength;
    }
    
    private int dfs(int[][] matrix, int row, int col, Set<String> seen) {
        int len = 1;
        // this cell is marked as visited, so do not consider this as a starter of a sequence
        seen.add(getKey(row, col));
        
        // look left
        if( isNextGreater(matrix, row, col, row, col+1))
            len = Math.max( len, 1 + dfs(matrix, row, col+1, seen));
    
        // look down
        if( isNextGreater(matrix, row, col, row+1, col))
            len = Math.max( len, 1 + dfs(matrix, row+1, col, seen));
        
        // look right
        if( isNextGreater(matrix, row, col, row, col-1))
            len = Math.max( len, 1 + dfs(matrix, row, col-1, seen));
        
        // look up
        if( isNextGreater(matrix, row, col, row-1, col))
            len = Math.max( len, 1 + dfs(matrix, row-1, col, seen));
         
        return len;
    }
                   
    private String getKey(int row, int col) {
        return row + "_" + col;
    }  
    
    private boolean isNextGreater(int[][] matrix, int row, int col, int otherRow, int otherCol) {
        if(otherRow >= 0 && otherRow < matrix.length &&
          otherCol >= 0 && otherCol < matrix[0].length &&
          matrix[otherRow][otherCol] > matrix[row][col]) return true;
        
        return false;
    }
    
}
