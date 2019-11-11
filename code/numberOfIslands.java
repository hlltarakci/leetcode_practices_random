// Approach 1:

class Solution {
    /*
      https://leetcode.com/problems/number-of-islands/
      
      m: # of rows
      n: # of cols
      time: O(mn)
      space: O( min(m,n) ) --
        queue usage
        in worst case, everywhere is land
        the queue will be filled up to min(m,n)
      
      BFS
    */
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                // if land, increment counter and turn around into water
                if(grid[i][j] == '1') {
                    count++;
                    turnIslandIntoWater(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void turnIslandIntoWater(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        
        addToQueue(queue, grid, i, j);
        
        while(!queue.isEmpty()) {
            int[] currentCoord = queue.remove();
            int x = currentCoord[0], y = currentCoord[1];
            
            // if neighbors are lands, put them in the queue
            // above
            if( x-1 >= 0 && grid[x-1][y] == '1') addToQueue(queue, grid, x-1, y); 
            // below
            if( x+1 < grid.length && grid[x+1][y] == '1') addToQueue(queue, grid, x+1, y);
            // left
            if( y-1 >= 0 && grid[x][y-1] == '1') addToQueue(queue, grid, x, y-1);
            // right
            if( y+1 < grid[0].length && grid[x][y+1] == '1') addToQueue(queue, grid, x, y+1);
        }
    }
    
    private void addToQueue(Queue<int[]> queue, char[][] grid, int i, int j) {
        // turn this spot into water before adding to queue
        grid[i][j] = '0';
        queue.add(new int[] {i, j});
    }
}
