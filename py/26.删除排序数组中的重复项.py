#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution:
    # * 一次循环，统计重复的数字个数n，然后将下一个数字往前移动n个位置。
    # 36ms 98%  86%  14.3MB
    def removeDuplicates1(self, nums: List[int]) -> int:
        duplicate_count = 0
        for i in range(1,len(nums)):
            if(nums[i-1] == nums[i]):
                duplicate_count += 1
            nums[i-duplicate_count] = nums[i]
        return len(nums) - duplicate_count

# * 统计不重复的元素个数n，然后将下一个元素的位置移动到n
# 40ms 96%   66%    14.4MB
    def removeDuplicates2(self, nums: List[int]) -> int:
        unique_count = 0
        for i in range(1,len(nums)):
            if nums[i-1] != nums[i]:
                unique_count += 1
                nums[unique_count] = nums[i]
        return unique_count+1

    # * 参照官方题解，双指针法，指针i遍历数组，指针j指向当前不重复的值，nums[i] != nums[j]时，nums[++j]=nums[a]
    # 与上面两个算法复杂度一样
    def removeDuplicates(self, nums: List[int]) -> int:
        j = 0
        for i in range(1,len(nums)):
            if nums[j] != nums[i]:
                j += 1
                nums[j] = nums[i]
        return j + 1
                
# @lc code=end

