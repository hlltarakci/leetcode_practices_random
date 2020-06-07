// https://leetcode.com/explore/interview/card/facebook/57/others-3/3039/

public class Solution {
    /*
        https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear
    */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num.toCharArray(), 0, target, 0, 0);
        return res;
    }
    public void dfs(List<String> res, StringBuilder sb, char[] num, int pos, int target, long prev, long multi) { 
        if(pos == num.length) {
            if(target == prev) res.add(sb.toString());
            return;
        }
        long curr = 0;
        for(int i = pos; i < num.length; i++) {
            if(num[pos] == '0' && i != pos) break;
            curr = 10 * curr + num[i] - '0';
            int len = sb.length();
            if(pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr); 
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr); 
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr); 
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i + 1, target, 
                    prev - multi + multi * curr, 
                    multi * curr); 
                sb.setLength(len);
            }
        }
    }
}
