/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    private Set<Integer> visited = new HashSet<>();
    private LinkedList<Integer> recRes = new LinkedList<>();
    /**
     * 用一个set保存访问过的元素
     * 循环选择第一个元素，递归选择后面的元素。
     * 8ms 7%   50%   39MB
     */
    public List<List<Integer>> permute1(int[] nums) {
        if(recRes.size() == nums.length) {
            res.add(new LinkedList(recRes));
            return res;
        }
        for(int i=0;i<nums.length;i++){
            if(visited.contains(nums[i])) continue;
            visited.add(nums[i]);
            recRes.add(nums[i]);
            permute(nums);
            visited.remove(nums[i]);
            recRes.removeLast();
        }
        return res;
    }

/**
 * 递归算法，跟方法1的不同点仅仅是每次迭代，在传入数组的基础上，创建一个长度短1的新数组
 * 新的数组不包含已经选过的数
 * 2ms   79%   80%   38.8MB
 */
    public List<List<Integer>> permute2(int[] nums) {
        if(nums.length == 0) {
            // recRes.add(nums[0]);
            res.add(new LinkedList(recRes));
            return res;
        }
        for(int i=0;i<nums.length;i++){
            recRes.add(nums[i]);
            int[] newNums = new int[nums.length-1];
            System.arraycopy(nums,0,newNums,0,i);
            System.arraycopy(nums,i+1,newNums,i,nums.length-i-1);
            permute(newNums);
            recRes.removeLast();
        }
        return res;
      
    }

    /**
     * 1，由输入的数组参数生产结果list
     * 2，遍历结果list
     * 3，每次交换两个值，开始位置递增1然后进入迭代
     * 4，迭代完成后还原数组
     * 5，当迭代开始位置==数组长度数到达迭代深度
     * 2ms    79%    42%     39.1MB
     */

    public List<List<Integer>> permute(int[] nums) {
        for(int num:nums) recRes.add(num);
        dfs(0);
        return res;
      
    }

    private void dfs(int first){
        if(first == recRes.size()){
            res.add(new LinkedList<>(recRes));
            return;
        }
        for(int i=first;i<recRes.size();i++){
            Collections.swap(recRes,i,first);
            dfs(first+1);
            Collections.swap(recRes,first,i);
        }
    }
}
// @lc code=end

