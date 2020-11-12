#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#

# @lc code=start
class Solution:
    # 递归算法
    # 用循环选择第一个元素，然后用递归选择第二个元素
    # 404   61%   11.6%    14.9MB
    def combine1(self, n: int, k: int) -> List[List[int]]:
        res = []
        inner_list = []
        def dfs(start,count):
            if count == k:
                res.append(inner_list.copy())
                return
            for i in range(start+1,n+1):
                inner_list.append(i)
                dfs(i,count+1)
                inner_list.pop()
        dfs(0,0)
        return res
        # 在算法一的基础上优化了变量，增加了减枝
        # 64ms    73%     10.9%   14.9MB
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        inner_list = []
        def dfs(start):
            if len(inner_list) == k:
                res.append(inner_list.copy())
                return
            for i in range(start+1,n+len(inner_list)-k+2):
                inner_list.append(i)
                dfs(i)
                inner_list.pop()
        dfs(0)
        return res
# @lc code=end

