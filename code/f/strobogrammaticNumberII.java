// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/3029/

class Solution {
    /*
        https://leetcode.com/problems/strobogrammatic-number-ii/discuss/644459/Java-Recurision
    */
    public List<String> findStrobogrammatic(int n) {
        return find(n,  n);
    }
    
    private List<String> find(int remaining, int n){
        if(remaining == 0) return Arrays.asList("");
        if(remaining == 1) return Arrays.asList("0", "1", "8");

        List<String> results = new ArrayList<>();
        
        List<String> potentialResults = find(remaining-2, n);
        
        for(String potentialResult: potentialResults) {
            if(remaining != n) results.add("0" + potentialResult + "0");
            results.add("1" + potentialResult + "1");
            results.add("8" + potentialResult + "8");
            results.add("6" + potentialResult + "9");
            results.add("9" + potentialResult + "6");
        }
        
        return results;
    }
}
