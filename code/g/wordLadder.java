class Solution {
    /*
      https://leetcode.com/problems/word-ladder/
      note: each time a word is put in queue, it is put in a set too - for a seen chech
      BFS: put beginWord in queue, put a delimiter to indicate level-1 is complete when you get there
      while queue is not empty:
        get word from queue
        if that word is delimiter, we are one level above in the graph- increment counter (len of transformation) and continue
        if that word is the endWord - we found the word, just return count
        visit wordList:
            if word is seen before - just continue
            otherwise put the word in the queue
        if peak of queue shows a delimiter, we processed all in that level, time to level up, put a delimiter in queue
        
        n: number of words
        w: word length
        time complexity: O(n^2 w) --> n^2 is because for each word in queue, we make a wordlist visit
        --> some improvement might happen here, if we remove the word we saw from oiginal list in O(1) time 
          (for that, swap with the last element in list and remove last element)
        --> w comes from distance calc 
        space complexity: O(nm) --> queue usage, hashset usage
          worst case: all words one level distant to our word, all end up in queue
        
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int count = 0;
        Set<String> seen = new HashSet<>();
        Queue<String> wordQueue = new LinkedList<>();
        // need to mark and of a level, so that we can count 
        String delimiter = "*";
        wordQueue.add(beginWord);
        wordQueue.add(delimiter);
        seen.add(beginWord);
        
        boolean found = false;
        while(!wordQueue.isEmpty()) {
            String word = wordQueue.remove();
            
            // check if it is delimiter
            if(word.equals(delimiter)) {
                count++;
                continue;
            }
            
            // if found endWord, found shortest transformation already
            if(word.equals(endWord)) {
                found = true;
                break;
            }
            
            // otherwise, go check 1 letter-away options
            for(String nextWord: wordList) {
                // already processed, so pass it
                if(seen.contains(nextWord)) continue;
                
                // if one-letter away, put it in the queue
                if(isOneLetterAway(word, nextWord)) {
                    wordQueue.add(nextWord);
                    seen.add(nextWord);
                }
            }
            
            // if layer is done, put a delimiter
            if(wordQueue.peek().equals(delimiter)) {
                wordQueue.add(delimiter);
            }
        }
        
        return found ? count+1 : 0;
    }
    
    private boolean isOneLetterAway(String word, String otherWord) {
        boolean oneLetterAway = false;
        for(int i=0; i<word.length();i++) {
            if(word.charAt(i) == otherWord.charAt(i)) continue;
            
            if(oneLetterAway) return false;
            oneLetterAway = true;
        }
        
        return oneLetterAway;
    }
}
