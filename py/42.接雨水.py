#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#

# @lc code=start
class Solution:
    #      * 暴力法 每个柱子的积水区，取决于左边界的最大值，右边界的最小值 两者中的较小者减去柱子本身的高度
    #  * 时间复杂度是n*n
    #  time limit exceeded
    def trap1(self, height: List[int]) -> int:
        res = 0
        for i in range(1,len(height)-1):
            left_max, right_max = 0, 0
            for j in range(i,-1,-1):
                left_max = max(left_max,height[j])
            for j in range(i,len(height)):
                right_max = max(right_max,height[j])
            res += (min(right_max,left_max)-height[i])
        return res
        
#  * 三趟扫描
#  * 第一次扫描每个柱子的左边界
#  * 第二次扫描每个柱子的右边界
#  * 第三次遍历数组，取左右边界高度的最小值减去柱子的高度
#  * 40ms   95%    7%  14MB
 
    def trap2(self, height: List[int]) -> int:
        if height is None or len(height)==0:
            return 0
        res = 0
        left_max_list = [-1] * len(height)
        right_max_list = [-1] * len(height)
        left_max_list[0] = height[0]
        right_max_list[-1] = height[-1]
        for i in range(1,len(height)):
            left_max_list[i] = max(left_max_list[i-1],height[i])
        for i in range(len(height)-2,-1,-1):
            right_max_list[i] = max(right_max_list[i+1],height[i])
        for i in range(len(height)):
            res += (min(left_max_list[i],right_max_list[i])-height[i])

        return res
    
#       * 用栈的存储左边界
#  * 56ms   37%   73%    13.7MB
    def trap3(self, height: List[int]) -> int:
        res = 0
        stack = []
        current = 0
        while current < len(height):
            while len(stack) >0  and height[current] > height[stack[-1]]:
                top = stack.pop()
                if len(stack)==0:
                    break
                distance = current - stack[-1] - 1
                res += (distance* (min(height[current],height[stack[-1]])-height[top]))
            stack.append(current)
            current += 1

        return res
#     * 双指针最快
#  * 44ms  97.99%   46%  13.8MB
    def trap(self, height: List[int]) -> int:
        res = 0
        left,right = 0,len(height) - 1
        left_max,right_max = 0,0
        while left < right:
            if height[left]<height[right]:
                if height[left] > left_max:
                    left_max = height[left]
                else:
                    res += left_max - height[left]
                left += 1
            else:
                if height[right] > right_max:
                    right_max = height[right]
                else:
                    res += right_max - height[right]
                right -= 1

        return res

# @lc code=end

