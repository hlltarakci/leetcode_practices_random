// https://leetcode.com/explore/interview/card/facebook/56/design-3/300/

class WordDictionary {
    class Trie {
        int N = 26;
        public char ch;
        public Trie[] children;
        public boolean isEnd;
        public Trie(char ch) {
            this.ch = ch;
            children = new Trie[N];
        }
    }

    Trie root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie('-');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie curr = root;
        for(char ch: word.toCharArray()) {
            int index = ch - 'a';
            if(curr.children[index] == null) curr.children[index] = new Trie(ch);
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }
    
     private boolean search(String word, Trie trie) {
        Trie curr = trie;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
           
            if(ch != '.') {
                int index = ch - 'a';
                if(curr.children[index] == null) return false;
                curr = curr.children[index];
            } else {
                for(Trie child: curr.children) {
                    if(child != null && search(word.substring(i+1), child)) return true;
                }
                
                return false;
            }
        }
         
        return curr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
