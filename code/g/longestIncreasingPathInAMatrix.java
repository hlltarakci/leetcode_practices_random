// Approach 1

class Solution {
    /*
        https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
        Time Limit Exceeded
        Approach: Naive DFS 
        for each entry, examine 4-directions and check for increasing sequences
        
        observation: not necessary to check for cells
        that are already follower of a sequence
        
        m: num of rows
        n: num of cols
        time: O(4^(m+n)) -- ? letcode says O(2^(m+n))
        space: O(mn) -- depth of recursion could go up to that in worst case + hashset usage
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

// Approach 2

class Solution {
    /*
        https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
        
        DFS + memoization
        for each entry, examine 4-directions and check for increasing sequences
        
        observation: not necessary to check for cells
        that are already follower of a sequence
        
        observation: just cache the results for entries, so reduce time complexity to O(mn)
            since every cell is touched once
        
        time: O(mn)
        space: O(mn) -- due to cache usage
    */
    public int longestIncreasingPath(int[][] matrix) {
        // corner case
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int longestPathLength = 0;
        Set<String> seen = new HashSet<>();
        int[][] cache = new int[matrix.length][matrix[0].length];
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(cache[i][j] == 0) {
                   int len = dfs(matrix, i, j, cache);
                   longestPathLength = Math.max(longestPathLength, len);
                }
            }
        }
        
        return longestPathLength;
    }
    
    private int dfs(int[][] matrix, int row, int col, int[][] cache) {
        
        if(cache[row][col] != 0) return cache[row][col];
        
        int len = 1;
        
        // look left
        if( isNextGreater(matrix, row, col, row, col+1))
            len = Math.max( len, 1 + dfs(matrix, row, col+1, cache));
    
        // look down
        if( isNextGreater(matrix, row, col, row+1, col))
            len = Math.max( len, 1 + dfs(matrix, row+1, col, cache));
        
        // look right
        if( isNextGreater(matrix, row, col, row, col-1))
            len = Math.max( len, 1 + dfs(matrix, row, col-1, cache));
        
        // look up
        if( isNextGreater(matrix, row, col, row-1, col))
            len = Math.max( len, 1 + dfs(matrix, row-1, col, cache));
         
        // cache result, so that no computation again
        cache[row][col] = len;
        return len;
    }
         
    private boolean isNextGreater(int[][] matrix, int row, int col, int otherRow, int otherCol) {
        if(otherRow >= 0 && otherRow < matrix.length &&
          otherCol >= 0 && otherCol < matrix[0].length &&
          matrix[otherRow][otherCol] > matrix[row][col]) return true;
        
        return false;
    }
    
}
