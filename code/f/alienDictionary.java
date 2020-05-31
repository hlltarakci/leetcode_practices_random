// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/3025/

class Solution {
    /*
        https://leetcode.com/articles/alien-dictionary/#
        n: words count
        c: total length of words 
        U: alphabet size
        time: O(c)
        space: adj list uses (V+E) space where V is u and E is min(n, u^2) ==> O(u + min(n, u^2))
        if we say alphabet size is 26, then this is constant ==> O(1)
    */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        
        if(!populateAdjListAndCheck(words, adjList, indegrees)) return "";
        
        return bfs(adjList, indegrees);
    }
    
    private String bfs(
        Map<Character, List<Character>> adjList, 
        Map<Character, Integer> indegrees) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        for(Character ch: indegrees.keySet()) {
            if(indegrees.get(ch) == 0) queue.add(ch);
        }
        
        while(!queue.isEmpty()) {
            Character ch = queue.remove();
            sb.append(ch);
            for(Character neig: adjList.get(ch)) {
                indegrees.put(neig, indegrees.get(neig)-1);
                if(indegrees.get(neig) == 0) queue.add(neig);
            }
        }
        
        return indegrees.size() == sb.length() ? sb.toString() : "";
    }
    
    private boolean populateAdjListAndCheck(
        String[] words,
        Map<Character, List<Character>> adjList, 
        Map<Character, Integer> indegrees) {
        
        for(String word: words) {
            for(Character ch: word.toCharArray()) {
                adjList.put(ch, new ArrayList<>());
                indegrees.put(ch, 0);
            }
        }
        
        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)) return false;
            
            int smallWordLen = Math.min(word1.length(), word2.length());
            for(int j=0; j<smallWordLen; j++) {
                if(word1.charAt(j) == word2.charAt(j)) continue;
                adjList.get(word1.charAt(j)).add(word2.charAt(j));
                indegrees.put(word2.charAt(j), indegrees.get(word2.charAt(j))+1);
                break;
            }
        }
        
        return true;
    }
    
}
