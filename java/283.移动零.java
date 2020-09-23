/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    /**
     * 遍历数组，统计0元素的个数n，遇到非零元素往前移动n个位置
     * 一次遍历完成后，所有的非零元素都在数组前面，根据非零元素的数量将数组最后n个元素设为0
     * 0ms 100%     62%     39.1MB
     */
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
            }else{
                nums[i-zeroCount] = nums[i];
            }
        }
        for(int i=nums.length-zeroCount;i<nums.length;i++)nums[i]=0;
    }
}
// @lc code=end

