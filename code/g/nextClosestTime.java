class Solution {
    /*
    https://leetcode.com/problems/next-closest-time/
    
    time: O(1) -- since evry option is limited, it is constant
    space: O(1)
    
    case analysis
    i am not very happy of the modularity of this code,
    but this is how i best grasped the problem, so this is what it is..
    */
    public String nextClosestTime(String time) {
        StringBuilder nextTime = new StringBuilder();
        
        if( tryIncreaseTime(nextTime, time, true) ) return nextTime.toString();
        if( tryIncreaseTime(nextTime, time, false) ) return nextTime.toString();
        
        int minDigit = getMinDigit(time);
        nextTime.append(minDigit).append(minDigit).append(":").append(minDigit).append(minDigit);
        
        return nextTime.toString();
    }
    
    private boolean tryIncreaseTime(StringBuilder nextTime, String time, boolean isMinutes) {
        String[] timeParts = time.split(":");
        int value, limit;
        
        if(isMinutes) {
            value = Integer.valueOf(timeParts[1]);
            limit = 60;
        } else {
            value = Integer.valueOf(timeParts[0]);
            limit = 24;
        }
        
        for(int i=value+1; i<limit; i++) {
            if(doesTimeContainDigits(time, i)) {
                if(isMinutes) {
                    nextTime.append(timeParts[0]).append(":");
                    if(i/10 < 1) nextTime.append("0");
                    nextTime.append(i);
                } else {
                    int minDigit = getMinDigit(time);
                    if(i/10 < 1) nextTime.append("0");
                    nextTime.append(i).append(":").append(minDigit).append(minDigit);
                }
                return true;
            }
        }
        
        return false;
    }
        
    private int getMinDigit(String time) {
        int minDigit = 9;
        
        for(char c: time.toCharArray()) {
            int value = Character.getNumericValue(c) ;
            if( value >= 0)
                minDigit = Math.min(minDigit, value);
        }
        
        return minDigit;
    }
    
    private boolean doesTimeContainDigits(String time, int num) {
        int digit1 = num / 10, digit2 = num % 10;
        
        if(time.indexOf(Integer.toString(digit1)) >= 0 && 
           time.indexOf(Integer.toString(digit2)) >= 0 ) return true;
        return false;
    }
        
}
