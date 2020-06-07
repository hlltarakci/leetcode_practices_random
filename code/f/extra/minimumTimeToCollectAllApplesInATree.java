// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Integer> map = populateMap(edges);
        Set<String> visited = new HashSet<>();
        int count = 0;
        for(int i=0; i<hasApple.size(); i++) {
            if(!hasApple.get(i)) continue;
            int vertex = i;
            while(vertex != 0) {
                String key1 = vertex + "_" + map.get(vertex);
                String key2 = map.get(vertex) + "_" + vertex;
                
                if(!visited.contains(key1)) {
                    visited.add(key1);
                    visited.add(key2);
                    count+=2;
                }
                vertex = map.get(vertex);
            }
        }
        return count;
    }
    
    private Map<Integer, Integer> populateMap(int[][] edges) {
        Map<Integer, int[]> map = new HashMap<>();
        
        for(int i=0; i<edges.length; i++) {
            map.put(edges[i][1], edges[i][0]);
        }
        
        return map;
    }
}
