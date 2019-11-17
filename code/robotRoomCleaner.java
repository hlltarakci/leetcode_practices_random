/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    /*
        https://leetcode.com/problems/robot-room-cleaner/
        great explanation here: https://www.youtube.com/watch?v=VQp7pfij7_Q
        
        time and space complexity seems controversial, reading the discussion in comments might be helpful:
        https://leetcode.com/articles/robot-room-cleaner/
        
        n: number of available cells without obstacles (we cannot visit obstacles, so do not include them in time complexity)
        time: leetcode says O(4^n) -- for each cell, we check 4 directions
            discussions, people say that we visit each cell only once, so it should be O(n) due to the visited set
            second seems more likely to me
        space: O(n) -- hashset usage -- what about recursion stack?? 
     */
    public void cleanRoom(Robot robot) {
        dfs(robot,0, 0, 0, new HashSet<String>());
    }
    
    private void dfs(Robot robot, int row, int col, int dir, Set<String> cleaned) {
        String key = row + "_" + col;
        
        // already cleaned here, just return
        if(cleaned.contains(key)) return;
        
        // clean where am i and add to cleaned set
        robot.clean();
        cleaned.add(key);
        
        // examine 4 directions around me
        for(int i=0; i<4; i++) {
            // if robot can move
            if(robot.move()) {
                // decide next row and col
                int nextRow = row, nextCol = col;
                switch(dir) {
                    case 0: nextRow--; break;
                    case 90: nextCol++; break;
                    case 180: nextRow++; break;
                    case 270: nextCol--; break;
                }
                // clean next cell
                dfs(robot, nextRow, nextCol, dir, cleaned);
                
                // when done, come back
                goBack(robot);
            }
            // try next dir
            dir += 90;
            dir = dir % 360;
            robot.turnRight();
        }
    }
    
    public void goBack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
