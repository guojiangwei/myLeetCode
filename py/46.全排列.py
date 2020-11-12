#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#

# @lc code=start
class Solution:
    # * 用一个set保存访问过的元素
    #  * 循环选择第一个元素，递归选择后面的元素。
    # 48ms     38%     18.67%    13.6MB
    def permute1(self, nums: List[int]) -> List[List[int]]:
        res = []
        rec_res = []
        visited = {}
        def dfs():
            if len(rec_res) == len(nums):
                res.append(rec_res.copy())
                return
            for i in range(len(nums)):
                if visited.get(nums[i], None) is not None:
                    continue
                visited[nums[i]] = i
                rec_res.append(nums[i])
                dfs()
                del visited[nums[i]]
                rec_res.pop()
        dfs()
        return res
    
#      * 递归算法，跟方法1的不同点仅仅是每次迭代，在传入数组的基础上，创建一个长度短1的新数组
#  * 新的数组不包含已经选过的数
# 44ms   63%    7%   13.7MB
    def permute2(self, nums: List[int]) -> List[List[int]]:
        res = []
        rec_res = []
        def dfs(nums):
            if len(nums) == 0:
                res.append(rec_res.copy())
                return
            for i in range(len(nums)):
                rec_res.append(nums[i])
                dfs(nums[0:i]+nums[i+1:])
                rec_res.pop()
        dfs(nums)
        return res

    #          * 1，由输入的数组参数生产结果list
    #  * 2，遍历结果list
    #  * 3，每次交换两个值，开始位置递增1然后进入迭代
    #  * 4，迭代完成后还原数组
    #  * 5，当迭代开始位置==数组长度数到达迭代深度
    # 52ms   18%   5%   13.8MB
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        rec_res = []
        def dfs(first):
            if len(nums) == first:
                res.append(rec_res.copy())
                return
            for i in range(first,len(nums)):
                rec_res.append(nums[i])
                nums[i], nums[first] = nums[first], nums[i]
                dfs(first+1)
                rec_res.pop()
                nums[first], nums[i] = nums[i], nums[first]
        dfs(0)
        return res
# @lc code=end

