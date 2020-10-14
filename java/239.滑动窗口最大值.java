/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {

    private int findMaxIndex(int start, int end, int[] nums){
        int maxIndex = start;
        for(int i = start +1;i<end;i++){
            if(nums[i] >= nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    /**
     * 1，先求出前k的元素的最大值
     * 2，移动窗口，当新加入的值大于前一个窗口的最大值，直接更新最大值并记录当前最大值的下标
     * 3，如果当前扫描的值小于之前的最大值，判断前一个最大值的是否在当前的窗口内，如果在最大值不变
     * 4，如果扫描的值小于之前的最大值，并且最大值的下标在滑动窗口外，重新计算最大值
     * 798ms   12%   5%   57.7MB
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int i = k;
        int maxIndex=findMaxIndex(0,k,nums);
        res.add(nums[maxIndex]);
        for(;i<nums.length;i++ ){
            if (nums[i] >= nums[maxIndex]){
                res.add(nums[i]);
                maxIndex = i;
                continue;
            }
            if((i-maxIndex)>=k ){
                maxIndex = findMaxIndex(i-k+1,i+1,nums);
            }
                res.add(nums[maxIndex]);
            
        }
        int [] intRes = new int[res.size()];
        for(i=0;i<res.size();i++){
            intRes[i] = res.get(i);
        }
        return intRes;
    }
    /**
     * 在方法一的基础上做了优化，省略了List结构，代码更简洁
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int [] intRes = new int[nums.length-k+1];
        int i = k;
        int maxIndex=findMaxIndex(0,k,nums);
        int resIndex=0;
        intRes[resIndex++] = nums[maxIndex];
        
        for(;i<nums.length;i++ ){
            if (nums[i] >= nums[maxIndex]){
                intRes[resIndex++] = nums[i];
                maxIndex = i;
                continue;
            }
            if((i-maxIndex)>=k ){
                maxIndex = findMaxIndex(i-k+1,i+1,nums);
            }
                intRes[resIndex++] = nums[maxIndex];
            
        }
        
        return intRes;
    }
/**
 * 动规 效率最高
 * 12ms     85%     29%      52MB
 */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
    
        int [] left = new int[n];
        left[0] = nums[0];
        int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
          // from left to right
          if (i % k == 0) left[i] = nums[i];  // block_start
          else left[i] = Math.max(left[i - 1], nums[i]);
    
          // from right to left
          int j = n - i - 1;
          if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
          else right[j] = Math.max(right[j + 1], nums[j]);
        }
    
        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
          output[i] = Math.max(left[i + k - 1], right[i]);
    
        return output;
      }
    
    
}
// @lc code=end

