#
# @lc app=leetcode.cn id=70 lang=python3
#
# [70] 爬楼梯
#

# @lc code=start
class Solution:
    # 递归 暴力法
    # Time Limit Exceeded
    # python 的方法内方法 让代码更加简洁
    def climbStairs1(self, n: int) -> int:
        def recusion(n):
            if n < 3:
                return n
            return recusion(n-1) + recusion(n-2)
        return recusion(n)
    
    # 一次循环
    # 用临时变量保存计算结果，首先确定初始情况
    # Python交换变量的值非常方便快捷
    # 44ms  47.99 %  68.71 %   13.3 MB
    def climbStairs2(self, n: int) -> int:
        if n<3:
            return n
        a,b,c = 1,2,0
        for i in range(2,n):
            c = a + b
            a,b = b,c
        return c

    # 一次循环
    # 用数组保存计算结果，首先确定初始情况
    # 40ms  67.99 %  48.71 %   13.4 MB
    def climbStairs3(self, n: int) -> int:
        if n<3:
            return n
        a = [1,2,0]
        for i in range(2,n):
            a[2] = a[0] + a[1]
            a[0],a[1] = a[1],a[2]

        return a[2]

    # 递归
    # 用数组保存计算结果，首先确定初始情况
    # 44ms  40.99 %  86.71 %   13.2 MB
    def climbStairs4(self, n: int) -> int:
        if n<3:
            return n
        a = [1,2,0]
        def recusion(a,n):
            if n<3:
                return
            a[2] = a[0] + a[1]
            a[0],a[1] = a[1],a[2]
            recusion(a,n-1)
        recusion(a,n)
        return a[2]
    # 一次循环
    # 用临时变量保存计算结果，首先确定初始情况
    # Python交换变量的值非常方便快捷，在方法2基础上继续减少变量，其他算法也可以类似的减少变量值
    # 28ms  98.99 %  68.71 %   13.3 MB
    def climbStairs5(self, n: int) -> int:
        if n<3:
            return n
        a,b = 1,2
        for i in range(2,n):
            b,a = a + b,b
        return b
    # 一次循环
    # 用临时变量保存计算结果，首先确定初始情况
    # Python交换变量的值非常方便快捷，在方法5基础上继续减少变量，
    # 把初始值设为从0开始，减少判断，代码更优雅
    # 其他算法也可以类似的减少变量值
    # 28ms  98.99 %  68.71 %   13.3 MB
    def climbStairs5(self, n: int) -> int:
        a,b = 0,1
        for _ in range(n):
            b,a = a + b,b
        return b
    
    # 递归 缓存计算结果，减少重复计算
    # 40ms  67%   9%  13.4
    # python 的方法内方法 让代码更加简洁
    def climbStairs(self, n: int) -> int:
        temp = {}
        def recusion(n):
            if n in temp:
                return temp[n]
            if n < 3:
                return n
            temp[n] = recusion(n-1) + recusion(n-2)
            return temp[n]
        return recusion(n)
# @lc code=end

