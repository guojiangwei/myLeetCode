#
# @lc app=leetcode.cn id=47 lang=python3
#
# [47] 全排列 II
#

# @lc code=start
class Solution:
    # 48ms    83%    10%   13.8MB
    def permuteUnique1(self, nums: List[int]) -> List[List[int]]:
        res = []
        output = []
        visited = [False] * len(nums)
        nums.sort()
        def dfs():
            if len(output) == len(nums):
                res.append(output[:])
            for i in range(len(nums)):
                if visited[i] or (i>0 and nums[i] == nums[i-1] and not visited[i-1]):
                    continue
                visited[i] = True
                output.append(nums[i])
                dfs()
                output.pop()
                visited[i] = False
        dfs()
        return res 
        # 跟算法一思想一样，写法更Python
        # 52ms   68%    9%   13.8MB
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        
        visited = [False] * len(nums)
        nums.sort()
        def dfs(output):
            if len(output) == len(nums):
                res.append(output[:])
            for i in range(len(nums)):
                if visited[i] or (i>0 and nums[i] == nums[i-1] and not visited[i-1]):
                    continue
                visited[i] = True
                dfs(output+[nums[i]])
                visited[i] = False
        dfs([])
        return res 

# @lc code=end

