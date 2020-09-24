/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    /**
     * 递归 暴力法
     * Time Limit Exceeded
     */
    public int climbStairs1(int n) {
        return recursion(n);
    }
    int recursion(int n){
        if(n<3){
            return n;
        }
        return recursion(n-1)+recursion(n-2);
    }

    /**
     * 一次循环
     * 用临时变量保存计算结果，首先确定初始情况
     * 0ms  100%  69.23 %   35.4 MB
     */
    public int climbStairs2(int n) {
        if(n<3)return n;
        int a=1,b=2,c=0;
        for(int i=3;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

    /**
     * 一次循环
     * 用数组维护三个变量，首先确定初始情况
     * 0ms  100%  83.23 %   35.4 MB
     */
    public int climbStairs3(int n) {
        if(n<3)return n;
        int[] a = {1,2,0};
        for(int i=3;i<=n;i++){
            a[2] = a[0]+a[1];
            a[0] = a[1];
            a[1]=a[2];
        }
        return a[2];
    }

    /**
     * 将循环改为递归方式
     * 用数组维护三个变量，首先确定初始情况
     * 0ms  100%  47.23 %   35.6 MB
     */
    public int climbStairs4(int n) {
        if(n<3)return n;
        int[] a = {1,2,0};
        recursion2(a,n);
        return a[2];
    }
    void recursion2(int[] a,int n){
        if(n<3){
            return;
        }
        a[2] = a[0] + a[1];
        a[0] = a[1];
        a[1] = a[2];
        recursion2(a,n-1);
    }

    // 递归 缓存计算结果，减少重复计算
    // 0ms  100%  6.23 %   35.8 MB

    public int climbStairs(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        return recursion3(map,n);
    }

    int recursion3(Map<Integer,Integer> map,Integer n){
        if(map.containsKey(n)) return map.get(n);

        if(n<3){
            return n;
        }
        Integer temp = recursion3(map,n-1)+recursion3(map,n-2);
        map.put(n,temp);
        return temp;
    }
}
// @lc code=end

