// https://leetcode.com/explore/interview/card/facebook/55/dynamic-programming-3/3037/

class NumMatrix {
    /*
        r, c: matrix rows, cols
        time: O(1) -- one fill all sums in O(r c) time, then all calls in O(1)
        space: O(r c)
    */
    int[][] matrix;
    int[][] sums;

    public NumMatrix(int[][] m) {
        matrix = m;
        
        if(!isValid()) return;
        
        sums = new int[matrix.length][matrix[0].length];
        
        for(int r=0; r<sums.length; r++) {
            for(int c=0; c<sums[0].length; c++) {
                if(r == 0 && c != 0) sums[r][c] = sums[r][c-1];
                else if(c == 0 && r != 0) sums[r][c] = sums[r-1][c];
                else if(r != 0 && c != 0) sums[r][c] = sums[r-1][c] + sums[r][c-1] - sums[r-1][c-1];  
                
                sums[r][c] += matrix[r][c];
            }
        }
    }
    
    private boolean isValid() {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        return true;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(!isValid()) return 0;
        
        int sum = sums[row2][col2];
        if(row1 != 0) sum -= sums[row1-1][col2];
        if(col1 != 0) sum -= sums[row2][col1-1];
        if(row1 != 0 && col1 != 0) sum += sums[row1-1][col1-1];
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
