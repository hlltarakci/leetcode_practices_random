// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/263/

class Solution {
    /*
        a, b: str lens
        time: O(max(a, b))
        space: O(max(a, b)) -- for output
    */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int base = 2;
        int iA = a.length()-1, iB = b.length()-1, carry = 0;
        while(iA >= 0 || iB >= 0) {
            int valA = iA >= 0 ? Character.getNumericValue(a.charAt(iA)) : 0;
            int valB = iB >= 0 ? Character.getNumericValue(b.charAt(iB)) : 0;
            int sum = valA + valB + carry;
            sb.append( sum % base);
            carry = sum / base;
            iA--;
            iB--;
        }
        
        if(carry > 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
}
