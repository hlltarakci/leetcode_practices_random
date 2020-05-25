// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/274/

class Solution {
    /*
        r, c: grid row and col
        time: O(r c)
        space: O(r c)
    */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int count = 0;
        for(int r=0; r < grid.length; r++) {
            for(int c=0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    count++;
                    turnToWater(grid, r, c);
                }
            }
        }
        
        return count;
    }
    
    private void turnToWater(char[][] grid, int r, int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;
        
        grid[r][c] = '0';
        turnToWater(grid, r-1, c);
        turnToWater(grid, r+1, c);
        turnToWater(grid, r, c-1);
        turnToWater(grid, r, c+1);
    }
}
