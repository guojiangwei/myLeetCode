/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    /**
     * 暴力法，n 次方就相乘n次
     * time limit exceeded
     */
    public double myPow1(double x, int n) {
        double res =  1;
        if(n==0) return res;
        if(x==1.0) return x;
        int pn = n;
        if(pn<0) pn = -pn;
        
        for(int i=0;i<pn;i++){
            res = x * res;
        }
        if(n<0) res = 1/res;
        return res;
    }

    /**
     * 1ms   97%   61%   36.3MB
     * 递归，分治
     * 分治结果，根据传入的偶数还是奇数，采用res * res 或者res*res*x
     */
    public double myPow2(double x, int n) {
        double res =  1;
        if(n==0) return res;
        long pn = n;
        if(pn<0) pn = -pn;
        
        res = divide(x,pn);
        if(n<0) res = 1/res;
        return res;
    }
    private double divide(double x,long n){
        if(n == 1) return x;
        long leftN = n/2;
        double leftRes = divide(x,leftN);
        return n%2 == 0 ?leftRes* leftRes:leftRes*leftRes*x;
    }

    /**
     * 迭代法
     * 1ms    97%    12%    37.9MS
     */
    public double myPow(double x, int n) {
        double res =  1;
        if(n==0) return res;
        long pn = n;
        if(pn<0) pn = -pn;
         double loopRes = x;
        // res = x;
        
        while(pn > 0){
            if(pn%2==1){
                res = res * loopRes;
            }
            loopRes = loopRes * loopRes;
            pn = pn/2;
        }
        if(n<0) res = 1.0/res;
        return res;
    }
}
// @lc code=end

