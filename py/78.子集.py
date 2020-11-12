#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#

# @lc code=start
class Solution:
        #     * 暴力法    位运算
        #  * 36ms 87%   15%   13.6MB
    def subsets1(self, nums: List[int]) -> List[List[int]]:
        res = []
        
        for mask in range(1<<len(nums)):
            output = []
            for i in range(len(nums)):
                if (mask& (1 << i) != 0):
                    output.append(nums[i])
            res.append(output)
        return res
        # 递归枚举
        # 44ms    44%    8%   13.6MB
    def subsets2(self, nums: List[int]) -> List[List[int]]:
        res = []
        output = []
        def dfs(cur):
            if cur == len(nums):
                res.append(output[:])
                return
            output.append(nums[cur])
            dfs(cur+1)
            output.pop()
            dfs(cur+1)
        dfs(0)
        return res

# python列表生成器
# 36   87%   5%    13.8MB
    def subsets3(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for i in range(len(nums)):
            res = res + [ [nums[i]] + num for num in res ]
        return res
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def dfs(cur,tmp):
            res.append(tmp)
            for i in range(cur,len(nums)):
                dfs(i,tmp+[nums[i]])
        dfs(0,[])
        return res


# @lc code=end

