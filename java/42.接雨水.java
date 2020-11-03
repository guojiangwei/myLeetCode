/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    /**
     * 暴力法 每个柱子的积水区，取决于左边界的最大值，右边界的最小值 两者中的较小者减去柱子本身的高度
     * 时间复杂度是n*n
     * 111ms   5.34%    99.52%  37.5MB
     */
    public int trap1(int[] height) {
        int max = 0;
        for(int i=1;i<height.length-1;i++){
            int maxLeft=0,maxRight=0;
            for(int j=i;j<height.length;j++){
                maxRight = Math.max(height[j],maxRight);
            }
            for(int j=i;j>=0;j--){
                maxLeft = Math.max(height[j], maxLeft);
            }
            max += Math.min(maxLeft,maxRight) - height[i];

        }
        return max;

    }
/**
 * 三趟扫描
 * 第一次扫描每个柱子的左边界
 * 第二次扫描每个柱子的右边界
 * 第三次遍历数组，取左右边界高度的最小值减去柱子的高度
 * 2ms   45%    95%  37.9MB
 */
    public int trap2(int[] height) {
        if(height==null || height.length==0) return 0;
        int max = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        rightMax[size-1] = height[size-1];
        for(int i=1;i<size;i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        for(int i=size-2;i>=0;i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        for(int i=0;i<size;i++){
            max += Math.min(rightMax[i],leftMax[i]) - height[i];
        }
        
        return max;

    }
/**
 * 用栈的存储左边界
 * 2ms   45%   92%    38MB
 */
    public int trap3(int[] height) {
        if(height==null || height.length==0) return 0;
        int max = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int curr = 0;
        while(curr<height.length){
            while(!stack.isEmpty()&&height[curr]>height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty())break;
                int distance = curr - stack.peek()-1;
                int boundedHeight = Math.min(height[curr],height[stack.peek()]) - height[top];
                max += boundedHeight*distance;
            }
            stack.push(curr++);
        }
        
        return max;
    }
/**
 * 双指针最快
 * 1ms  99.99%   88%  38.2MB
 */
    public int trap(int[] height) {
        int max = 0;
        int left =0,right=height.length-1;
        int leftMax=0,rightMax=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax = height[left];
                }else{
                    max += (leftMax-height[left]);
                }
                left++;
            }else{
                if(height[right]>rightMax){
                    rightMax = height[right];
                }else{
                    max += (rightMax-height[right]);
                }
                right--;
            }
        }
        return max;
    }
}
// @lc code=end

