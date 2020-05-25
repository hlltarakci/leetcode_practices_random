// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/277/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /*
        time: O(num of nodes)
        space: O(num of nodes)
    */
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Stack<Node> stack = new Stack<>();
        Map<Node, Node> map = new HashMap<>();
        
        stack.push(node);
        map.put(node, new Node(node.val));
        
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            for(Node neig: curr.neighbors) {
                if(!map.containsKey(neig)) {
                    stack.push(neig);
                    map.put(neig, new Node(neig.val));
                }
                map.get(curr).neighbors.add(map.get(neig));
            }
        }
        
        return map.get(node);
    }
}
