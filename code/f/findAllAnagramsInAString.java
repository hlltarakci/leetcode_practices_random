// https://leetcode.com/explore/interview/card/facebook/57/others-3/3040/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()) return list;
        
        int[] refMap = new int[26];
        for(char c: p.toCharArray()) refMap[c-'a']++;
        
        int[] map = new int[26];
        for(int i=0; i<p.length(); i++) map[s.charAt(i)-'a']++;
        if(Arrays.equals(refMap, map)) list.add(0);
        
        for(int i=p.length(); i<s.length(); i++) {
            map[s.charAt(i-p.length())-'a']--;
            map[s.charAt(i)-'a']++;
            if(Arrays.equals(refMap, map)) list.add(i-p.length()+1);
        }
        
        return list;
    }
}
