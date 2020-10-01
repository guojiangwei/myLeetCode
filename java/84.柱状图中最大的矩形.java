/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    /**
     * 暴力解法，双重循环
     * 需要注意的就是第一重循环需要遍历每个元素，需要计算单个长方形的面积
     * 最大面积是方法全局的
     * 最小高度是循环体层面的
     * 837ms   24%   18%   40.5MB
     */
    public int largestRectangleArea1(int[] heights) {
        int curHeight = 0;
        int curArea = 0;
        for(int i =0;i<heights.length;i++){
            curHeight = heights[i];
            curArea = Math.max(curHeight,curArea);
            for(int j = i+1;j<heights.length;j++){
                curHeight = Math.min(heights[j],curHeight);
                curArea = Math.max(curArea, curHeight*(j-i+1));
            }
        }
        return curArea;
    }
    /**
     * 遍历高度
     * 第一重循环取中间的高度，
     * 内层循环取左右边界
     * 983ms 14%   5%   40.8MB
     */
    public int largestRectangleArea2(int[] heights) {
        int left=0,right = 0,area=0;
        for(int i=0;i<heights.length;i++){
            left = i-1;
            right = i+1;
            while(left >= 0 && heights[left] >= heights[i])left--;
            while(right<heights.length && heights[right] >= heights[i])right++;
            area = Math.max(area,heights[i]*(right-left-1));
        }
        return area;
    }

    /**
     * 1.一次循环寻找每个元素的左边界
     * 2，第二次循环寻找每个元素的右边界
     * 3，遍历每个元素的左右边界计算面积
     * 13ms   65%    82%   39.8MB
     */
    public int largestRectangleArea3(int[] heights) {
        if(heights.length == 0) return 0;
        int[] lefts = new int[heights.length];
        int[] rights = new int[heights.length];
        lefts[0] = -1;
        rights[heights.length-1] = heights.length;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        stack.push(0);
        for(int i=1;i<heights.length;i++){
            if(heights[i]> heights[i-1]){
                lefts[i] = i-1;
            }else{
                while(stack.peek() != -1 && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                lefts[i] = stack.peek();
                
            }
            stack.push(i);
            
        }
        stack = new LinkedList<>();
        stack.push(heights.length);
        stack.push(heights.length-1);
        for(int j = heights.length-2;j>=0;j--){
            if(heights[j]>=heights[j+1]){
                rights[j] = j+1;
            }else{
                while(stack.peek() !=heights.length && heights[stack.peek()]>=heights[j]){
                    stack.pop();
                }
                rights[j]=stack.peek();
            }
            stack.push(j);
        }
        int area = 0;
        for(int i=0;i<heights.length;i++){
            area = Math.max(area,heights[i]*(rights[i]-lefts[i]-1));
        }
        return area;

    }
/**
 * 算法跟上面一样，就是写法不一样，初试条件，循环、判断更加简洁
 */
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] lefts = new int[length];
        int[] rights = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for(int i =0;i<length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            lefts[i] = (stack.isEmpty()?-1:stack.peek());
            stack.push(i);
        }
        stack.clear();
        for(int i = length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            rights[i] = (stack.isEmpty()?length:stack.peek());
            stack.push(i);
        }
        int area = 0;
        for(int i =0;i<length;i++){
            area = Math.max(area,heights[i]*(rights[i]-lefts[i]-1));
        }
        return area;
    }
}
// @lc code=end

