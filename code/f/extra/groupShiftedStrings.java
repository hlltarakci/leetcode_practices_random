// https://leetcode.com/problems/group-shifted-strings/

class Solution {
    /*
        n: str array len
        s: average string len
        time: O(n s)
        space: O(n s)
    */
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> results = new ArrayList<>();
        if(strings == null) return results;
        
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strings) {
            String key = getKey(str);
            List<String> result = map.getOrDefault(key, new ArrayList<String>());
            result.add(str);
            map.put(key, result);
        }
        
        for(List<String> value: map.values()) 
            results.add(value);
        
        return results;
    }
    
    private String getKey(String str) {
        if( str.length() == 0) return str;
        
        StringBuilder sb = new StringBuilder();
        int numVal = 1;
        char startChar = str.charAt(0);
        for(char c: str.toCharArray()) {
            int diff = c >= startChar ? (c - startChar) : (c + 26 - startChar);
            sb.append(diff).append("-");
        }
        
        return sb.toString();
    }
}
