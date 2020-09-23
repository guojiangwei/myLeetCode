/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    /**
     * 暴力法
     * 双重循环，枚举所有的边界组合
     * 复杂度是n^2
     * 478 ms   13.56 %     54.03 %     39.2 MB
     */
    public int maxArea1(int[] height) {
        int max = 0;
        for(int i=0;i<height.length-1;i++){
            for(int j = i+1;j<height.length;j++){
                max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
            }
        }
        return max;

    }
    /**
     * 双指针算法，左右两边同时移动指针，时间复杂度是n
     * 对比左右边界，谁小就移动谁
     * 5 ms     33.19 %     15.67 %     39.4 MB
     */
    public int maxArea2(int[] height) {
        int max = 0,i=0,j=height.length-1;
        while(i<j){
            max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]){
                i++;
                continue;
            }
            j--;
        }

        return max;

    }
    /**
     * 双指针算法，左右两边同时移动指针，时间复杂度是n
     * 对比左右边界，谁小就移动谁
     * 本方法在方法二的基础上省略的最小值的判断
     * 3 ms     92.81 %     45 %     39.2 MB
     */
    public int maxArea3(int[] height) {
        int max = 0,i=0,j=height.length-1;
        while(i<j){
            
            if(height[i]<height[j]){
                max = Math.max(max,(j-i)*height[i]);
                i++;
            }else{
                max = Math.max(max,(j-i)*height[j]);
                j--;
            }
            
        }

        return max;

    }

    /**
     * 双指针算法，左右两边同时移动指针，时间复杂度是n
     * 对比左右边界，谁小就移动谁
     * 本方法在方法二的基础上加快了边界的缩减，双指针逼近的更快
     * 2 ms     99.2 %     85.94 %     39 MB
     */
    public int maxArea(int[] height) {
        int max = 0,i=0,j=height.length-1;
        while(i<j){
            max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]){
                int temp = i+1;
                while(temp<j && height[temp]<=height[i])temp++;
                i = temp;
            }else{
                int temp = j-1;
                while(i<temp && height[temp]<=height[j])temp--;
                j = temp;
            }
            
        }

        return max;

    }
}
// @lc code=end

