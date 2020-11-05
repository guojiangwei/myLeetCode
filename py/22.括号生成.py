#
# @lc app=leetcode.cn id=22 lang=python3
#
# [22] 括号生成
#

# @lc code=start
class Solution:
    # 递归暴力法，
    # 104ms   6%   24%      13.6MB
    def generateParenthesis1(self, n: int) -> List[str]:
        res = []
        def generateAll(cur, n):
            if len(cur) == n:
                if valid(cur):
                    res.append("".join(cur))
                return
            cur[n] = "("
            generateAll(cur,n+1)
            cur[n] = ")"
            generateAll(cur,n+1)
        def valid(str):
            count = 0
            for c in str:
                if c == "(":
                    count += 1
                else:
                    count -= 1
                if count == -1:
                    return False
            return count == 0
            
        generateAll([""]*n*2,0)
        return res
# * 减枝算法，提前将不符合要求的路径减掉，另外用一个char数组保存中间结果
# 44ms     61%      10%      13.7MB
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def backTrack(cur, left, right,n):
            if len(cur) == left + right:
                res.append("".join(cur))
                return
            if left < n:
                cur[left+right] = "("
                backTrack(cur,left+1,right,n)
            if right < left:
                cur[right+left] = ")"
                backTrack(cur,left,right+1,n)
            
        backTrack([""]*n*2,0,0,n)
        return res
# @lc code=end

