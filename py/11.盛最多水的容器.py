#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# @lc code=start
class Solution:
    # 暴力法
    # 双重循环，枚举所有的边界组合
    # 复杂度是n^2
    # Time Limit
    def maxArea1(self, height: List[int]) -> int:
        max_area = 0
        for i in range(len(height)-1):
            for j in range(i+1, len(height)):
                max_area = max(max_area,(j-i)*min(height[i],height[j]))
        return max_area
    
    # 双指针算法，左右两边同时移动指针，时间复杂度是n
    # 对比左右边界，谁小就移动谁
    # 64 ms     85.64 %     35.4 %      14.8 MB
    def maxArea2(self, height: List[int]) -> int:
        max_area = 0
        i = 0
        j = len(height) -1
        while i<j:
            max_area = max(max_area,(j-i)*min(height[i],height[j]))
            if height[i] < height[j]:
                i +=1
            else:
                j -= 1

        return max_area
    # 双指针算法，左右两边同时移动指针，时间复杂度是n
    # 对比左右边界，谁小就移动谁
    # 本方法在方法二的基础上省略的最小值的判断
    # 64 ms     85.64 %     35.4 %      14.8 MB
    def maxArea3(self, height: List[int]) -> int:
        max_area = 0
        i = 0
        j = len(height) -1
        while i<j:
            if height[i] < height[j]:
                max_area = max(max_area,(j-i)*height[i])
                i +=1
            else:
                max_area = max(max_area,(j-i)*height[j])
                j -= 1

        return max_area
    # 双指针算法，左右两边同时移动指针，时间复杂度是n
    # 对比左右边界，谁小就移动谁
    # 本方法在方法二的基础上加快了边界的缩减，双指针逼近的更快
    # 60 ms     93.32 %     91.24 %     14.6 MB
    def maxArea(self, height: List[int]) -> int:
        max_area = 0
        i = 0
        j = len(height) -1
        while i<j:
            max_area = max(max_area,(j-i)*min(height[i],height[j]))
            if height[i] < height[j]:
                temp = i+1
                while temp < j and height[temp] <= height[i]:
                    temp +=1
                i = temp
            else:
                temp = j - 1
                while i < temp and height[temp] <= height[j]:
                    temp -= 1
                j = temp

        return max_area
# @lc code=end

