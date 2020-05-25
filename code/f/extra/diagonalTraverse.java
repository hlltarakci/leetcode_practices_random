// https://leetcode.com/problems/diagonal-traverse/

class Solution {
    /*
        r, c: matrix rows, cols
        time: O(r c)
        space: O(r c) -- for output
    */
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        
        int rows = matrix.length, cols = matrix[0].length;
        int[] result = new int[rows*cols];
        
        boolean isUp = true;
        int r=0, c=0;
        for(int i=0; i<result.length;) {
            // valid row,col
            if(r >= 0 && r < rows && c >= 0 && c < cols) {
                result[i++] = matrix[r][c];
            } 
            
            // isUp, invalid col
            else if(isUp && c >= cols) {
                c = cols-1;
                r = r+2;
                isUp = false;
                continue;
            }
            
            // isUp, invalid row
            else if(isUp && r < 0) {
                r = 0;
                isUp = false;
                continue;
            }
            
            // isDown, invalid row
            else if(!isUp && r >= rows) {
                r = rows-1;
                c = c+2;
                isUp = true;
                continue;
            }
            
            // isDown, invalid col
            else if(!isUp && c < 0) {
                c = 0;
                isUp = true;
                continue;
            }
            
            
            if(isUp) {
                r = r-1;
                c = c+1;
            } else {
                r = r+1;
                c = c-1;
            }
        }
        
        return result;
    }
    
}
