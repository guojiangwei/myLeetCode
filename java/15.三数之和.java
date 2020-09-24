/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    /**
     * 暴力法，三重循环
     * 1,排序
     * 2，每个循环都要去重
     * 3,排序后如果第一个数组大于0  最终结果不可能为0，跳出循环
     * Time Limit Exceeded
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i-1] == nums[i])continue;
            for(int j=i+1;j<nums.length-1;j++){
                if(j>i+1 && nums[j-1] == nums[j])continue;
                for(int k=j+1;k<nums.length;k++){
                    if(k>j+1 && nums[k-1] == nums[k])continue;
                    int temp = nums[i] + nums[j] + nums[k];
                    if(temp==0){
                        List<Integer> tempList = new LinkedList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        res.add(tempList);
                    }
                }
            }
        }
        return res;
        

    }

    /**
     * 双指针法，
     * 1,排序
     * 2，第一个循环选取第一个元素
     * 3,双指针逼近选取两个元素,注意双指针去重的写法
     * 27ms  44.38 %    5.01 %   43.8 MB
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int left=0,right =0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i-1] == nums[i])continue;
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(temp==0){
                    List<Integer> tempList = new LinkedList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    res.add(tempList);
                    while(++left < right && nums[left] == nums[left-1]);
                    while(--right > left && nums[right] == nums[right+1]);
                }else if(temp>0){
                    while(--right > left && nums[right] == nums[right+1]);
                }else{
                    // left++;
                    while(++left < right && nums[left] == nums[left-1]);
                }
            }
        }
        return res;
        

    }
    // # 双指针法，
    // # 1,排序
    // # 2，第一个循环选取第一个元素
    // # 3,双指针逼近选取两个元素,
    // # 4，用元组保存结果，set去重
    // # 35ms  17 %    10.01 %   43.3 MB
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int left=0,right =0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(i>0 && nums[i-1] == nums[i])continue;
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(temp==0){
                    List<Integer> tempList = new LinkedList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    set.add(tempList);
                    left++;
                    right--;
                    // while(++left < right && nums[left] == nums[left-1]);
                    // while(--right > left && nums[right] == nums[right+1]);
                }else if(temp>0){
                    right--;
                    // while(--right > left && nums[right] == nums[right+1]);
                }else{
                    left++;
                    // while(++left < right && nums[left] == nums[left-1]);
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
        

    }
}
// @lc code=end

