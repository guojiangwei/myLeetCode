#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] 旋转数组
#

# @lc code=start
class Solution:
    #      * 复制数组nums 为des
    #  * 反转后的数组nums[(i+k)%nums.length] = des[i];
    # 可以看到Python拷贝数组非常方便
    # 48%   51%   56%   13.6MB
    def rotate1(self, nums: List[int], k: int) -> None:
        des = nums[:]
        for i in range(len(nums)):
            nums[(i+k)%len(nums)] = des[i]
        """
        Do not return anything, modify nums in-place instead.
        """
#         * 利用循环队列的思想，移动数组k次
#  * 双重循环，外层循环k次，内存循环次数为数组长度，时间复杂度是n*k
# Time Limit Exceeded
    def rotate2(self, nums: List[int], k: int) -> None:
        for i in range(k):
            pre = nums[len(nums)-1]
            for j in range(len(nums)):
                tmp = nums[j]
                nums[j] = pre
                pre = tmp
    # * 翻转三次，第一次翻转整个数组，第二次翻转前面k个元素，第三次翻转后面n-k个元素
    # 52ms  39%   7%  13.7MB
    def rotate3(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        if k == 0:
            return
        def reverse(nums, start, end):
            k = int((end - start + 1)/2)
            for i in range(k):
                nums[start+i], nums[end] = nums[end], nums[start+i]
                end -= 1
        reverse(nums,0, len(nums)-1)
        reverse(nums, 0, k-1)
        reverse(nums, k, len(nums)-1)

    # * 翻转三次，第一次翻转整个数组，第二次翻转前面k个元素，第三次翻转后面n-k个元素
    # 使用双指针翻转
    # 40ms  89%   9%  13.7MB
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        if k == 0:
            return
        def reverse(nums, start, end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end -= 1
        reverse(nums,0, len(nums)-1)
        reverse(nums, 0, k-1)
        reverse(nums, k, len(nums)-1)



# @lc code=end

