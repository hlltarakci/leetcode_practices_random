// https://leetcode.com/problems/sudoku-solver/

class Solution {
    /*
        n = 9 (board dimension)
        one row time O(n!)
        all rows time: O( n! ^ n) 
        space: O(n^2)
    */
    public void solveSudoku(char[][] board) {
        Set<String> set = populateSet(board);
        backtrack(board, 0, 0, set);
    }
    
    private Set<String> populateSet(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int r=0; r<board.length; r++) {
            for(int c=0; c<board[0].length; c++) {
                if(board[r][c] == '.') continue;
                manageToSet(set, r, c, board[r][c], true);
            }
        }
        return set;
    }
    
    private boolean backtrack(char[][]board, int r, int c, Set<String> set) {
        if(r == board.length) {
            return true;
        }
        
        int nextR = r, nextC = c+1;
        if(nextC == board[0].length) {
            nextR++;
            nextC = 0;
        }
        
        if(board[r][c] != '.') return backtrack(board, nextR, nextC, set);
        
        for(char val='1'; val<='9'; val++) {
            if(isValid(set, r, c, val)){
                board[r][c] = val;
                manageToSet(set, r, c, val, true);
                if(backtrack(board, nextR, nextC, set)) return true;
                manageToSet(set, r, c, val, false);
            } 
        }
        board[r][c] = '.';
        
        return false;
    }
    
    
    private String getRowKey(int r, char val) {
        return "r" + r + "_" + val;
    }
    
    private String getColKey(int c, char val) {
        return "c" + c + "_" + val;
    }
    
    private String getBoxKey(int r, int c, char val) {
        int box = (r/3)*3 + c / 3;
        return "b" + box + "_" + val;
    }
    
    private void manageToSet(Set<String> set, int r, int c, char val, boolean isAdd) {
        String rowKey = getRowKey(r, val);
        String colKey = getColKey(c, val);
        String boxKey = getBoxKey(r, c, val);
        
        if(isAdd) {
            set.add(rowKey);
            set.add(colKey);
            set.add(boxKey);
        } else {
            set.remove(rowKey);
            set.remove(colKey);
            set.remove(boxKey);
        }
    }
    
    private boolean isValid(Set<String> set, int r, int c, char val) {
        String rowKey = getRowKey(r, val);
        String colKey = getColKey(c, val);
        String boxKey = getBoxKey(r, c, val);
        
        if(set.contains(rowKey) || set.contains(colKey) || set.contains(boxKey)) return false;
        
        return true;
    }
}
