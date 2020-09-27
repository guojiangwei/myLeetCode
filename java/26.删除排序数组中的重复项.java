/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    /**
     * 一次循环，统计重复的数字个数n，然后将下一个数字往前移动n个位置。
     * 1ms  98%   41  40.2MB
     */
    public int removeDuplicates1(int[] nums) {
        int duplicateCount = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                duplicateCount++;
            }
            nums[i-duplicateCount] = nums[i];
        }
        return nums.length - duplicateCount;
    }

    /**
     * 统计不重复的元素个数n，然后将下一个元素的位置移动到n
     * 1ms  98%   45.4%  40.7MB
     */
    public int removeDuplicates2(int[] nums) {
        int duplicateCount = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] !=nums[i]){
                nums[++duplicateCount] = nums[i];
            }
            
        }
        return duplicateCount+1;
    }
/**
 * 参照官方题解，双指针法，指针i遍历数组，指针j指向当前不重复的值，nums[i] != nums[j]时，nums[++j]=nums[a]
 * 1ms  98% 5% 41MB
 */
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[j] !=nums[i]){
                nums[++j] = nums[i];
            }
            
        }
        return j+1;
    }

}
// @lc code=end

