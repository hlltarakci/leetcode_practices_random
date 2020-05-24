// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3014/

class Solution {
    /*
        n: array len
        s: average str len
        time: O(ns)
        space: O(ns) -- map usage
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        
        
        return new ArrayList<>(map.values());
    }
}
