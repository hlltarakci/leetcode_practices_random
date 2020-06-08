// https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/3027/

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set<String>>> map = new HashMap<>();
        
        for(List<String> account: accounts) {
            String key = account.get(0);
            
            if(!map.containsKey(key)) {
                addToMap(account, map);
                continue;
            }
            
            List<Set<String>> sets = map.get(key);
            
            List<Set<String>> belongingSets = new ArrayList<>();
            for(int i=1; i<account.size(); i++) {
                for(Set<String> set: sets) {
                    if(set.contains(account.get(i))) {
                        belongingSets.add(set);
                        break;
                    }
                }
            }
            
            if(belongingSets.size() > 0) {
                for(Set<String> set: belongingSets) sets.remove(set);
                Set<String> combinedSet = new HashSet<>();
                for(Set<String> set: belongingSets) combinedSet.addAll(set);
                for(int k=1; k<account.size(); k++) combinedSet.add(account.get(k));
                sets.add(combinedSet);
            } else addToMap(account, map);
        }
        
        return convert(map);
    }
    
    private List<List<String>> convert(Map<String, List<Set<String>>> map) {
        List<List<String>> results = new ArrayList<>();
        for(String key: map.keySet()) {
            List<Set<String>> list = map.get(key);
            for(Set<String> set: list) {
                List<String> result = new ArrayList<>();
                result.addAll(set);
                Collections.sort(result);
                result.add(0, key);
                results.add(result);
            }
        }
        return results;
    }
    
    private void addToMap(List<String> account, Map<String, List<Set<String>>> map) {
        Set<String> set = new HashSet<>();
        for(int i=1; i<account.size(); i++) set.add(account.get(i));

        List<Set<String>> sets = map.getOrDefault(account.get(0), new ArrayList<>());
        sets.add(set);
        map.put(account.get(0), sets);
    }
}
