// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/273/

class Solution {
    // https://leetcode.com/problems/integer-to-english-words/discuss/650444/Readable-and-Easy-Java-Solution
    
    public String THOUSANDS[] = {"", "Thousand", "Million", "Billion"};
    public String LESS_THAN_TWENTY[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String TENS[] = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        StringBuilder sb = new StringBuilder();
        
        int part = 0;
        while(num > 0) {
            // last 3 digits
            if(num % 1000 != 0) {
                String numberInWords = toWords(num % 1000).trim() + " " + THOUSANDS[part] + " ";
                
                sb.insert(0, numberInWords);
            }
            part++;
            num /= 1000;
        }
        
        return sb.toString().trim();
    }
    
    private String toWords(int num) {
        if (num == 0) return "";
        
        if(num < 20) return LESS_THAN_TWENTY[num];
        
        if(num < 100) return TENS[num/10] + " " + toWords(num % 10);
        
        return LESS_THAN_TWENTY[num/100] + " Hundred " + toWords(num % 100); 
    }
}
