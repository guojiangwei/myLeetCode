#
# @lc app=leetcode.cn id=50 lang=python3
#
# [50] Pow(x, n)
#

# @lc code=start
class Solution:
    # 迭代
    # 56ms    5%    5%    13.6MB
    def myPow1(self, x: float, n: int) -> float:
        res = 1
        if n ==0 :
            return res
        pn = n
        if pn < 0:
            pn = -pn
        loop_res = x
        while pn > 0:
            if pn%2 == 1:
                res = res*loop_res
            loop_res = loop_res * loop_res
            pn = int(pn/2)
        if n < 0:
            res = 1/res
        return res

# 递归法
# 56ms   5%   5%   13.7MB
    def myPow2(self, x: float, n: int) -> float:
        res = 1
        if n ==0 :
            return res
        pn = n
        if pn < 0:
            pn = -pn
        def divide(n):
            if n == 1:
                return x
            divide_res = divide(int(n/2))
            return divide_res*divide_res if n%2==0 else divide_res * divide_res* x
        res = divide(pn)

        return res if n>0 else 1/res

# 递归法，使用位运算代替除法和偶数判断
# 40ms    72%   41%   13,4MB
    def myPow3(self, x: float, n: int) -> float:
        res = 1
        if n ==0 :
            return res
        pn = n
        if pn < 0:
            pn = -pn
        def divide(n):
            if n == 1:
                return x
            divide_res = divide(n>>1)
            return divide_res*divide_res if n&1==0 else divide_res * divide_res* x
        res = divide(pn)

        return res if n>0 else 1/res
    
        # 迭代
    # 40ms    72%    5%    13.7MB
    def myPow(self, x: float, n: int) -> float:
        res = 1
        if n ==0 :
            return res
        pn = n
        if pn < 0:
            x = 1/x
            pn = -pn
        loop_res = x
        while pn > 0:
            if pn&1:
                res = res*loop_res
            loop_res = loop_res * loop_res
            pn = pn >> 1
        return res
# @lc code=end

