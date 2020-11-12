/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        LinkedList<Integer> output = new LinkedList<>();
        // for(int num:nums)output.add(num);
        boolean[] visited = new boolean[nums.length];
        dfs(nums,output,visited);
        return res;
    }
    private void dfs(int [] nums,LinkedList<Integer> output, boolean[] visited){
        if(nums.length == output.size()){
            res.add(new LinkedList<>(output));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i] || (i>0 && nums[i] == nums[i-1] && !visited[i-1])) continue;
            visited[i] = true;
            output.add(nums[i]);
            dfs(nums, output,visited);
            output.removeLast();
            visited[i] = false;
        }
    }
}
// @lc code=end

