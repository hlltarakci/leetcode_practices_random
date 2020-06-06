// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/3026/

class Solution {
    public int shortestDistance(int[][] grid) {
        int shortest = Integer.MAX_VALUE;
        int buildingCount = calcBuildingCount(grid);
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] != 0) continue;
                int distance = calcDistance(grid, r, c, buildingCount);
                shortest = Math.min(distance, shortest);
            }
        }
        
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
    
    private int calcDistance(int[][] grid, int r, int c, int buildingCount) {
        int distance = 0, reachBuildingCount = 0;
        int[][] dirs = new int[][] {
            {-1, 0}, {0,-1}, {1, 0}, {0, 1}
        };
        
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[] {r, c});
        queue.add(null);
        visited.add(r + "_" + c);
        
        int steps = 0;
        while(!queue.isEmpty()) {
            int[] coord = queue.remove();
            
            if(coord == null) {
                steps++;
                if(!queue.isEmpty()) queue.add(null);
                continue;
            }
            
            int row = coord[0], col = coord[1];
            
            if(grid[row][col] == 1) {
                reachBuildingCount++;
                distance += steps;
                
                if(reachBuildingCount == buildingCount) return distance;
            }
            else if(grid[row][col] == 0) {
                for(int[] dir: dirs) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    String key = nextRow + "_" + nextCol;
                    if(nextRow >= 0 && nextRow < grid.length &&
                       nextCol >= 0 && nextCol < grid[0].length &&
                       !visited.contains(key)) {
                        queue.add(new int[] {nextRow, nextCol});
                        visited.add(key);
                    }
                }
                
            }
            
        }
        
        return Integer.MAX_VALUE;
    }
    
    private int calcBuildingCount(int[][] grid) {
        int buildingCount = 0;
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == 1) buildingCount++;
            }
        }
        
        return buildingCount;
    }
}
