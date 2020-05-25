// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/269/

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */

public class Solution extends Reader4 {
    char[] internal = new char[4];
    int readIndex = 0;
    int readLen = 0;
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int actualRead = 0;
        while(n > 0 && readIndex < readLen) {
            buf[actualRead++] = internal[readIndex++];
            n--;
        }
        
        while(n > 0 &&  (readLen = read4(internal)) > 0) {
            readIndex = 0;
            while(n > 0 && readIndex < readLen) {
                buf[actualRead++] = internal[readIndex++];
                n--;
            }
        }
        
        return actualRead;
    }
}
