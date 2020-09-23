/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    /**
     * 暴力法
     * 双重循环遍历数组，复杂度为n^2
     * 60 ms  45.11 %  15.37  39.2 MB
     */
    public int[] twoSum1(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];

    }

    /**
     * 两边hash表法
     * 先将所有数组元素加入map中
     * 遍历数组，如果数组元素与target的差值存在数组中，返回符合要求的数组
     * 3ms  74.11 %     24.29 %     39.2 MB
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)map.put(nums[i],i);

        for(int i=0;i<nums.length-1;i++){
            if(map.get(target-nums[i])!=null && map.get(target-nums[i]) != i){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[0];

    }

    /**
     * 一趟扫描数组法
     * 使用map存储数组元素与target的差值
     * 遍历数组当数组元素为之前遍历过的元素的差值时，返回符合要求的数组
     * 当数组元素不是遍历过的元素的与target的差值时，将差值放入map中
     * 2 ms   99.61 %   79.7 %   38.9 MB
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) !=null){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return new int[0];

    }
}
// @lc code=end

