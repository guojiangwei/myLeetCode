#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#

# @lc code=start
class Solution:
    # 暴力法，三重循环
    # 1,排序
    # 2，每个循环都要去重
    # 3,排序后如果第一个数组大于0  最终结果不可能为0，跳出循环
    # Time Limit Exceeded
     
    def threeSum1(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        for i in range(len(nums)-2):
            if i>0 and nums[i-1] == nums[i]:
                continue
            for j in range(i+1,len(nums)-1):
                if j>i+1 and nums[j-1] == nums[j]:
                    continue
                for k in range(j+1,len(nums)):
                    if k>j+1 and nums[k-1] == nums[k]:
                        continue
                    temp = nums[i] + nums[j] + nums[k]
                    if temp == 0:
                        res.append([nums[i],nums[j],nums[k]])
                        break
        return res
    
    # 双指针法，
    # 1,排序
    # 2，第一个循环选取第一个元素
    # 3,双指针逼近选取两个元素,注意双指针去重的写法
    # 1032ms  47.38 %    56.01 %   15.9 MB
    def threeSum2(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        for i in range(len(nums)-2):
            left,right = i+1,len(nums)-1
            if nums[i] > 0: break
            if i>0 and nums[i] == nums[i-1]:continue
            while left<right:
                temp = nums[i] + nums[left] + nums[right]
                if temp==0:
                    res.append([nums[i],nums[left],nums[right]])
                    left += 1
                    right -= 1
                    while left < right and nums[left] == nums[left-1]:
                        left += 1
                    while left < right and nums[right] == nums[right+1]:
                        right -= 1
                elif temp<0:
                    left += 1
                    while left < right and nums[left] == nums[left-1]:
                        left += 1
                else:
                    right -= 1
                    while left < right and nums[right] == nums[right+1]:
                        right -= 1
        return res
    # 双指针法，
    # 1,排序
    # 2，第一个循环选取第一个元素
    # 3,双指针逼近选取两个元素,
    # 4，用元组保存结果，set去重
    # 680ms  93 %    96.01 %   15.7 MB
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        for i in range(len(nums)-2):
            left,right = i+1,len(nums)-1
            if nums[i] > 0: break
            if i>0 and nums[i] == nums[i-1]:continue
            while left<right:
                temp = nums[i] + nums[left] + nums[right]
                if temp==0:
                    res.append((nums[i],nums[left],nums[right]))
                    left += 1
                    right -= 1
                elif temp<0:
                    left += 1
                else:
                    right -= 1
        return list(set(res))
# @lc code=end

