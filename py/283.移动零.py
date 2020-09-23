#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] 移动零
#

# @lc code=start
class Solution:
    # 遍历数组，统计0元素的个数n，遇到非零元素往前移动n个位置
    # 一次遍历完成后，所有的非零元素都在数组前面，根据非零元素的数量将数组最后n个元素设为0
    # 64 ms     23.14 %     32.18 %     14 MB
    def moveZeroes1(self, nums: List[int]) -> None:
        zeroCount = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                zeroCount += 1
            else:
                nums[i-zeroCount] = nums[i]
        
        for i in range(len(nums)-zeroCount,len(nums)):
            nums[i] = 0

        """
        Do not return anything, modify nums in-place instead.
        """
        # 遍历数组，记录第一个0出现的位置
        # 当元素非零时，且前面有0时，与前面的0交换位置，且位置加一
        # 52 ms     34.47 %     68.63 %     14MB
    def moveZeroes(self, nums: List[int]) -> None:
        posi = -1
        for i in range(len(nums)):
            if nums[i] == 0 and posi==-1:
                posi  = i
            if nums[i] != 0 and posi != -1:
                nums[posi],nums[i] = nums[i], nums[posi]
                posi += 1
        
# @lc code=end

