/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    /**
     * 复制数组nums 为des
     * 反转后的数组nums[(i+k)%nums.length] = des[i];
     * 0ms  100%   36.9%   39.5MB
     */
    public void rotate1(int[] nums, int k) {
        int[] des = new int[nums.length];
        System.arraycopy(nums,0,des,0,nums.length);
        for(int i=0;i<nums.length;i++){
            nums[(i+k)%nums.length] = des[i];
        }
    }
/**
 * 利用循环队列的思想，移动数组k次
 * 双重循环，外层循环k次，内存循环次数为数组长度，时间复杂度是n*k
 * 281ms 10%   45%    39.4MB
 */
    public void rotate2(int[] nums, int k) {
        for(int ii=0;ii<k;ii++){
            
            int tmp2=nums[0];
        for(int i = 0;i<nums.length-1;i++){
            int tmp = nums[i+1];
            nums[i+1] = tmp2;
            tmp2 = tmp;
        }
        nums[0] = tmp2;
    }
    }
    /**
 * 利用循环队列的思想，移动数组k次
 * 双重循环，外层循环k次，内存循环次数为数组长度，时间复杂度是n*n
 * 与方法二的区别就是内存循环逻辑不一样，但是循环次数一样
 * 该方法的内存循环更简洁
 * 267ms 19%   42%    39.4MB
 */
public void rotate3(int[] nums, int k) {
    for(int ii=0;ii<k;ii++){
        
        int pre=nums[nums.length-1];
    for(int i = 0;i<nums.length;i++){
        int tmp = nums[i];
        nums[i] = pre;
        pre = tmp;
    }
}
}
/**
 * 翻转三次，第一次翻转整个数组，第二次翻转前面k个元素，第三次翻转后面n-k个元素
 * 1ms   56%    19.9%   39.6MS
 */
public void rotate(int[] nums, int k) {
    k = k%nums.length;
    if(k==0) return;
    reverse(nums,0,nums.length-1);
    reverse(nums,0,k-1);
    reverse(nums,k,nums.length-1);
}
void reverse(int[] nums,int start,int end){
    int count = (end - start+1)/2 ;
    int tmp = 0;
    for(int i=0;i<count;i++ ){
        tmp = nums[start+i];
        nums[start+i] = nums[end];
        nums[end--] = tmp;
        
    }
}


}
// @lc code=end

