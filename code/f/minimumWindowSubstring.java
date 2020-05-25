// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/285/

class Solution {
    /*
        s, t: str lens
        time: O(s + t)
        space: O(s + t)
    */
    public String minWindow(String s, String t) {
        String minStr = "";
        Map<Character, Integer> mapTemplate = template(t);
        Map<Character, List<Integer>> mapReal = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!mapTemplate.containsKey(c)) continue;
            
            List<Integer> indexList = mapReal.getOrDefault(c, new ArrayList<>());
            indexList.add(i);
            mapReal.put(c, indexList);
         
            int startIndex = getStartIndex(mapTemplate, mapReal);
            String subStr = startIndex >= 0 ? s.substring(startIndex, i+1) : "";
            minStr = minStr.length() == 0 || minStr.length() > subStr.length() ? subStr : minStr;
        }
        
        return minStr;
    }
    
    private int getStartIndex(Map<Character, Integer> template, Map<Character, List<Integer>> real) {
        int startIndex = -1;
        for(char key: template.keySet()) {
            Integer freq = template.get(key);
            List<Integer> indexes = real.getOrDefault(key, new ArrayList<>());
            if(indexes.size() < freq) return -1;
            
            int index = indexes.get(indexes.size()-freq);
            startIndex = startIndex < 0 ? index : Math.min(startIndex, index);
        }
        
        return startIndex;
    }
    
    private Map<Character, Integer> template(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        return map;
    }
}
