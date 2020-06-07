// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/268/

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
     public int read(char[] buf, int n) {
        char[] temp = new char[4];
        
        int actualRead = 0;
        
        while(actualRead < n) {
            int count = Math.min(read4(temp), n-actualRead);
            for(int i=0; i<count; i++) {
                buf[actualRead++] = temp[i];
            }
            
            if(count < 4) break;
        }
        
        return actualRead;
    }
}
