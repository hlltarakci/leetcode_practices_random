// https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    /*
        v: vertices
        e: edges
        time: O(v+e)
        space: O(v)
    */
    public boolean isBipartite(int[][] graph) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i=0; i<graph.length; i++) {
            
            if(set1.contains(i) || set2.contains(i)) continue;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while(!queue.isEmpty()) {
                int fromVertex = queue.remove();
                for(int toVertex: graph[fromVertex]) {
                    boolean isFromInSet1 = set1.contains(fromVertex);
                    boolean isFromInSet2 = set2.contains(fromVertex);
                    boolean isToInSet1 = set1.contains(toVertex);
                    boolean isToInSet2 = set2.contains(toVertex);

                    if(isFromInSet1 && isToInSet1 ||
                       isFromInSet2 && isToInSet2) return false;

                    if(isFromInSet1 && isToInSet2 ||
                       isFromInSet2 && isToInSet1) continue;

                    if(isFromInSet1) set2.add(toVertex);
                    if(isFromInSet2) set1.add(toVertex);

                    if(isToInSet1) set2.add(fromVertex);
                    if(isToInSet2) set1.add(fromVertex);

                    if(!isFromInSet1 && !isFromInSet2 &&
                       !isToInSet1 && !isToInSet2) {
                        set1.add(fromVertex);
                        set2.add(toVertex);
                    }

                    queue.add(toVertex);
                }
            }
        }
        
        return true;
    }
}
