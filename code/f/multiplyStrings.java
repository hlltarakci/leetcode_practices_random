// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3013/

class Solution {
    /*
        n, m: str lens
        time: O(max(n,m)) ?
        space: O(max(n,m)) ?
    */
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        List<String> sums = new ArrayList<>();
        int offset = num2.length()-1;
        for(char c: num2.toCharArray()) sums.add(multiply(num1, c - '0', offset--));
        return doSums(sums);
    }
    
    private String doSums(List<String> sums) {
        if(sums.size() == 1) return sums.get(0);
        
        String result = sums.get(0);
        for(int i=1; i<sums.size(); i++) result = add(result, sums.get(i));
        
        return result;
    }
    
    private String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        
        int index1 = num1.length()-1, index2 = num2.length()-1;
        int carry = 0;
        while(index1 >= 0 || index2 >= 0) {
            int val1 = index1 >= 0 ? num1.charAt(index1--) - '0' : 0;
            int val2 = index2 >= 0 ? num2.charAt(index2--) - '0' : 0;
            
            int sum = val1 + val2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        
        if(carry > 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
    
    private String multiply(String num, int digit, int offset) {
        StringBuilder sb = new StringBuilder();
        while(offset-- > 0) sb.append('0');
        int carry = 0;
        for(int i=num.length()-1; i >= 0; i--) {
            int val = num.charAt(i) - '0';
            int sum = (val * digit) + carry;
            sb.append( sum % 10);
            carry = sum / 10;
        }
        
        if(carry > 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
    
}
