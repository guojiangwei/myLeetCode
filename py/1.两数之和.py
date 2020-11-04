#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    #      * 暴力法
    #  * 双重循环遍历数组，复杂度为n^2
    # 5268ms    26%    63%    14.2MB
    def twoSum1(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)-1):
            for j in range(i+1,len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []

    #  
    #  * 先将所有数组元素加入map中
    #  * 遍历数组，如果数组元素与target的差值存在数组中，返回符合要求的数组
    # 44ms    92%    5%   15MB
    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        dict1 = { key:value for value,key in enumerate(nums)}
        for i,num in enumerate(nums):
            val = dict1.get(target-num, None)
            if  val!= None and val != i:
                return [i, dict1.get(target-num)]
        return []

# 32ms    99%     35%    14.5MB
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict1 = { }
        for i,num in enumerate(nums):
            val = dict1.get(target-num, None)
            if  val!= None:
                return [i, dict1.get(target-num)]
            dict1[num] = i
        return []

# @lc code=end

