/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    private List<String> res = new LinkedList<>();

    /**
     * 暴力法，
     * 2ms   36%   66%   38.8MB
     */
    public List<String> generateParenthesis1(int n) {
        generateAll(new char[n*2],0);
        return res;
    }
    private void generateAll(char[] cur, int n){
        if(n == cur.length) {
            if(valid(cur))res.add(String.valueOf(cur));
            return;
        }
        cur[n] = '(';
        generateAll(cur,n+1);
        cur[n] = ')';
        generateAll(cur,n+1);

    }

    private boolean valid(char[] parenthesis){
        int count = 0;
        for(char c :parenthesis){
            if(c=='('){
                count++;
            }else{
                count--;
            }
            if(count < 0) return false;
        }
        return count == 0;
    }

    /**
     * 减枝算法，提前将不符合要求的路径减掉，另外用一个char数组保存中间结果
     * 0ms   100%    70%   38.8MB
     */
    public List<String> generateParenthesis(int n) {
        backTrack(new char[n*2],0,0,n);
        return res;
    }
    private void backTrack(char[] cur, int left,int right,int n){
        if(cur.length == (left + right) ){
            res.add(String.valueOf(cur));
            return;
        }
        if(left<n){
            cur[left+right] = '(';
            backTrack(cur,left+1,right,n);
            
        }
        if(right<left){
            cur[left+right] = ')';
            backTrack(cur,left,right+1,n);
        }
    }

}
// @lc code=end

