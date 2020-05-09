class Solution {
    /*
    https://leetcode.com/problems/unique-email-addresses/
    
    time O(total content of emails) - a.k.a O(numOfEmails * string size) - string concat takes time proportional to its size
    space O(total content of emails) - worst case: every email is different
    
    another interpretation on time and space:
    time O(n) - where n is num of emails
    space O(n)
    with assumption - size of email address is bound, so any operations on them can be considered O(1) -- emails are short strings
      
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
