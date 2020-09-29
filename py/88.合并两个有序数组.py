#
# @lc app=leetcode.cn id=88 lang=python3
#
# [88] 合并两个有序数组
#

# @lc code=start
class Solution:
    # 将nums2拷贝给nums1
    # 排序nums1
    # 此方法有点取巧
    # 32ms  97%      56%   13.4MB
    def merge1(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        for i in range(m,len(nums1)):
            nums1[i] = nums2[i-m]
        nums1.sort()
    #  * 1,将nums1中的元素拷贝到临时数组
    #  * 2，用两个指针分别指向临时数组和数组二，谁的元素小就把谁拷贝到数组一，并移动指针
    #  * 3，根据指针位置判断临时数组和数组二剩余的元素，并全部拷贝到nums1
    # 48ms  23%   71%  13.3MB
    def merge2(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        tmp = nums1[:]
        i,j=0,0
        while i<m and j<n:
            if tmp[i] < nums2[j]:
                nums1[i+j] = tmp[i]
                i += 1
            else:
                nums1[i+j] = nums2[j]
                j += 1
        for i1 in range(i,m):
            nums1[i1+j] = tmp[i1]
        for i1 in range(j,n):
            nums1[i1+i] = nums2[i1]
    # * 1,题目以及假设nums1 长度有m+2
    #  * 2，将nums1的数字全部拷贝到数组尾部，nums1的前n个元素可以直接覆盖
    #  * 3，从nums1的第n个元素跟nums第一个元素开始比对
    # 44ms 50%  94%  13.2MB
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        i,j = m-1,n-1
        while j >=0 :
            if i>= 0 and nums1[i] > nums2[j]:
                nums1[i+j+1] = nums1[i]
                i -= 1
            else:
                nums1[i+j+1] = nums2[j]
                j -= 1
# @lc code=end

