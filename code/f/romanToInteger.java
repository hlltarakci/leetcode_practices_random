// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3010/

class Solution {
    /*
        time: O(1) -- since max is definite, can be considered constant
        space: O(1) -- assume alphabet fixed length for map usage
    */
    public int romanToInt(String s) {
        if(s == null) return 0;
        Map<Character, Integer> map = populateMap();
        
        int val=0, prev=0;
        for(char c: s.toCharArray()) {
            int currVal = map.get(c);
            val += currVal;
            if(prev < currVal) val -= prev*2; 
            prev = currVal;
        }
        
        return val;
    }
    
    private Map<Character, Integer> populateMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}
