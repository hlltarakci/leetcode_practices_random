class Solution {
    /*
    https://leetcode.com/problems/unique-email-addresses/
     Test:
        ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
        set:  testemail@leetcode.com, testemail@lee.tcode.com
        returns 2
    */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        String delimiter = "@";
        
        for(String email: emails) {
            String[] emailParts = email.split(delimiter);
            String localName = processLocalName(emailParts[0]);
            String domainName = emailParts[1];
            set.add(localName + delimiter + domainName);
        }
        
        return set.size();
    }
    
    private String processLocalName(String localName) {
        StringBuilder sb = new StringBuilder();
        
        for(char c: localName.toCharArray()) {
            if(c == '.') continue;
            
            if(c == '+') break;
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}
