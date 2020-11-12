/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<Integer> output = new LinkedList<>();
    
        /**
         * 暴力法    位运算
         * 1ms 98%   86%   38.8MB
         */
        public List<List<Integer>> subsets1(int[] nums) {
            int n = nums.length;

            for(int mask=0;mask<(1<<n);mask++){
                List<Integer> t = new ArrayList<Integer>();
                for(int i=0;i<n;i++){
                    if((mask & (1<<i)) != 0){
                        t.add(nums[i]);
                    }
                }
                ans.add(t);
            }
            return ans;
        }
/**
 * 递归  枚举
 * 1ms   98%   84%    38.8MB
 */
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            dfs(0,nums);
            return ans;
        }
        public void dfs(int cur, int nums[]){
            if(cur == nums.length){
                ans.add(new LinkedList<>(output));
                return;
            }
            output.add(nums[cur]);
            dfs(cur+1,nums);
            output.removeLast();
            dfs(cur+1,nums);
        }
}
// @lc code=end

