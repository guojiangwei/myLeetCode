/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    /**
     * 1，从数组的最高位，如果数组元素小于9加一后直接返回数组，如果数组元素等于0，设置为0，并进位
     * 2，当数组最高位为9时扩充数组，新数组最高位为1 其余为0
     * 0ms    100%    72%    37.2MB
     */
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        for(;i>=0;i--){
            if(digits[i] != 9){
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
    
}
// @lc code=end

