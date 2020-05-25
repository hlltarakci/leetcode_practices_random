// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3018/

class Solution {
    /*
        n: str len
        time: O(n)
        space: O(1)
    */
    public String validIPAddress(String IP) {
        if(isIPv4(IP)) return "IPv4";
        if(isIPv6(IP)) return "IPv6";
        return "Neither";
    }
    
    private boolean isIPv4(String IP) {
        if(IP.startsWith(".") || IP.endsWith(".")) return false;
        String[] words = IP.split("\\.");
        if(words.length != 4) return false;
        
        for(String word: words) {
            if(word.length() == 0 || word.length() > 3) return false;
            if(word.startsWith("0") && !word.equals("0")) return false;
            for(char c: word.toCharArray()) {
                if(!Character.isDigit(c)) return false;
            }
            int val = Integer.parseInt(word);
            if(val < 0 || val > 255) return false;
        }
        
        return true;
    }
    
    private boolean isIPv6(String IP) {
        if(IP.startsWith(":") || IP.endsWith(":")) return false;
        String[] words = IP.split(":");
        String hexdigits = "0123456789abcdefABCDEF";
        if(words.length != 8) return false;
        
        for(String word: words) {
            if(word.length() == 0 || word.length() > 4) return false;
            for(char c: word.toCharArray()) {
                if(hexdigits.indexOf(c) < 0) return false;
            }
        }
        
        return true;
    }
}
