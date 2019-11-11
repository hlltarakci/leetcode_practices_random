class Solution {
    /*
        https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/
        
        n: number of nodes
        e: number of edges
        time: O(ne) -- O(n) for root finding, this is done e times ? (actually, there cannot be more than e traversals on roots ??)
        possible to go doen to O(log n) for root finding, is union find is implemented better, 
        considering sizes of components and ensuring to union the smaller component - trying to keep tree balanced
        
        Approach: Union Find
    */
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i=0; i<roots.length; i++) roots[i] = i;
        
        for(int[] edge: edges) {
            int rootA = findRoot(roots, edge[0]);
            int rootB = findRoot(roots, edge[1]);
            
            // cycle detected, not valid tree
            if(rootA == rootB) return false;
            
            roots[rootA] = roots[rootB];
        }
        
        // if not exactly one root, not valid tre
        return countRoots(roots) == 1;
    }
    
    private int countRoots(int[] roots) {
        int count = 0;
        for(int i=0; i<roots.length; i++) {
            if(roots[i] == i) count++;
        }
        return count;
    }
    
    private int findRoot(int[] roots, int num) {
        while(roots[num] != num) {
            num = roots[num];
        }
        
        return num;
    }
    
}
