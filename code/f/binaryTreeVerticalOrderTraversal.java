// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/298/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        n: num of nodes
        time: O(n)
        space: O(n)
    */
    class NodeWithIndex {
        public TreeNode node;
        public int index;
        
        public NodeWithIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> verticals = new ArrayList<>();
        
        if(root == null) return verticals;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int min = 0, max = 0;
        
        Queue<NodeWithIndex> queue = new LinkedList();
        queue.add(new NodeWithIndex(root, 0));
        
        while(!queue.isEmpty()) {
            NodeWithIndex node = queue.remove();
            min = Math.min(min, node.index);
            max = Math.max(max, node.index);
            
            List<Integer> list = map.getOrDefault(node.index, new ArrayList<>());
            list.add(node.node.val);
            map.put(node.index, list);
            
            if(node.node.left != null) queue.add(new NodeWithIndex(node.node.left, node.index-1));
            if(node.node.right != null) queue.add(new NodeWithIndex(node.node.right, node.index+1));
        }
        
        for(int i=min; i<=max; i++) {
            if(!map.containsKey(i)) continue;
            verticals.add(map.get(i));
        }
        
        
        return verticals;
    }
    
}
