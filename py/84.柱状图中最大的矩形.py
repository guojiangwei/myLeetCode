#
# @lc app=leetcode.cn id=84 lang=python3
#
# [84] 柱状图中最大的矩形
#

# @lc code=start
class Solution:
    #      * 暴力解法，双重循环
    #  * 需要注意的就是第一重循环需要遍历每个元素，需要计算单个长方形的面积
    #  * 最大面积是方法全局的
    #  * 最小高度是循环体层面的
    # Time Limit Exceeded
    def largestRectangleArea1(self, heights: List[int]) -> int:
        area = 0
        for i in range(len(heights)):
            height = heights[i]
            for j in range(i,len(heights)):
                height = min(heights[j],height)
                area = max(area,(j-i+1)*height)
        return area
    # 暴力法
    #          * 遍历高度
    #  * 第一重循环取中间的高度，
    #  * 内层循环取左右边界
#     Time Limit Exceeded
# 94/96 cases passed (N/A)
    def largestRectangleArea2(self, heights: List[int]) -> int:
        area = 0
        for i in range(len(heights)):
            left = i-1
            right = i + 1
            while left>=0 and heights[left] >= heights[i]:
                left -= 1
            while right<len(heights) and heights[right] >= heights[i]:
                right += 1
            area = max(area,(right - left - 1)*heights[i])
        return area
    #          * 1.一次循环寻找每个元素的左边界
    #  * 2，第二次循环寻找每个元素的右边界
    #  * 3，遍历每个元素的左右边界计算面积
    # 100ms  9%  13.9%  15.7MB
    def largestRectangleArea(self, heights: List[int]) -> int:
        lefts,rights = [0]*len(heights),[0]*len(heights)
        stage = list()
        for i in range(len(heights)):
            while len(stage) !=0 and heights[stage[-1]] >= heights[i]:
                stage.pop()
            lefts[i] = (-1 if len(stage)==0 else stage[-1])
            stage.append(i)
        stage = list()
        for i in range(len(heights)-1,-1,-1):
            while len(stage) != 0 and heights[stage[-1]] >= heights[i]:
                stage.pop()
            rights[i] = (len(heights) if len(stage)==0 else stage[-1])
            stage.append(i)
        
        area = 0
        for i in range(len(heights)):
            area = max(area,heights[i]*(rights[i] - lefts[i] - 1))
        return area

            
# @lc code=end

