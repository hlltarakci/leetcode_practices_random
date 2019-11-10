class Solution {
    /*
      https://leetcode.com/problems/fruit-into-baskets/
      
      n: tree size
      time O(n)
      space O(1)
    */
    public int totalFruit(int[] tree) {
        int max = 0;
        
        int count = 0;
        int type1 = -1, type2 = -1, lastSeenIndexOfType1 = -1, lastSeenIndexOfType2 = -1;
        
        for(int i=0; i<tree.length; i++) {
            int type = tree[i];
            // we have a new type (other than existing two)
            // adjust accordingly
            if(type1 >= 0 && type2 >= 0 && type != type1 && type != type2) {
                // get rid of the type that is more distant now
                // and take over that slot for new type
                if(lastSeenIndexOfType1 < lastSeenIndexOfType2) {
                    count = i - lastSeenIndexOfType1;
                    lastSeenIndexOfType1 = i;
                    type1 = type;
                } else {
                    count = i - lastSeenIndexOfType2;
                    lastSeenIndexOfType2 = i;
                    type2 = type;
                }
                
                continue;
            }
            
            // we pick current fruit anyway
            count++;
            max = Math.max(max, count);
            
            // no type1 yet, set it
            if(type1 < 0) {
                type1 = type;
                lastSeenIndexOfType1 = i;
                
                continue;
            }
            
            // no type2 yet, set it
            if(type != type1 && type2 < 0) {
                type2 = type;
                lastSeenIndexOfType2 = i;
                
                continue;
            }
            
            // we are re-picking a fruit of type1 or type2, set its last seen index
            if(type == type1) lastSeenIndexOfType1 = i;
            else lastSeenIndexOfType2 = i;
        }
        
        return max;
    }
}
