class Solution {
    /*
        https://leetcode.com/problems/license-key-formatting/
    */
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder formattedLicenseKey = new StringBuilder();
        char delimiter = '-';
        
        StringBuilder part = new StringBuilder();
        for(int i=S.length()-1; i>=0; i--) {
            char c = S.charAt(i);
            if(c == delimiter) continue;
            
            part.append(Character.toUpperCase(c));
            if(part.length() == K) {
                formattedLicenseKey.append(part.toString()).append(delimiter);
                part = new StringBuilder();
            }
        }
        
        if(part.length()!= 0) formattedLicenseKey.append(part.toString());
        else if(formattedLicenseKey.length()>0) formattedLicenseKey.deleteCharAt(formattedLicenseKey.length()-1); 
        
        return formattedLicenseKey.reverse().toString();
    }
}
