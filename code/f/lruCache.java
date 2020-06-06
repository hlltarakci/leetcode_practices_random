// https://leetcode.com/explore/interview/card/facebook/56/design-3/311/

class LRUCache {
    class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;
        
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if(node == null) return -1;
        
        if(tail == node && tail.prev != null) tail = node.prev;
        
        if(head != node) {
            if(node.prev != null) node.prev.next = node.next;
            if(node.next != null) node.next.prev = node.prev;

            node.next = head;
            head.prev = node;

            head = node;
        }
        
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(map.get(key) != null) {
            node = map.get(key);
            node.val = value;
        }
        
        if(head != null && node != head) {
            if(node.next != null) node.next.prev = node.prev;
            if(node.prev != null) node.prev.next = node.next;
            
            if(node == tail) tail = node.prev;
            
            node.next = head;
            head.prev = node;
        }
        
        head = node;
        
        if(tail == null) tail = node;
        
        map.put(key, node);
        
        cleanup();
    }
    
    private void cleanup() {
        if(map.size() > capacity) {
            map.remove(tail.key);
            if(tail.prev != null) tail.prev.next = null;
            tail = tail.prev;
        }
    }
    
}

/* approach: extend LinkedHashMap
class LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRUCache(int capacity) {
        // initialCapacity - the initial capacity
        // loadFactor - the load factor
        // accessOrder - the ordering mode - true for access-order, false for insertion-order
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    @Override 
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}
*/

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
