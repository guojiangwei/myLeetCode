/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    /**
     * 递归算法
     * 递归里面有个循环体，用来选取第一个数字
     * 23ms   45%   11%   41.3MB
     */
    public List<List<Integer>> combine(int n, int k) {
        if(k<=0 || n<k) return res;
        Deque<Integer> path = new LinkedList<>();
        dfs(n,k,1,path);

        return res;
    }
    private void dfs(int n, int k,int start, Deque<Integer> path){
        if(path.size() == k){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i=start;i<=n;i++){
        path.push(i);
        dfs(n,k,i+1,path);
        path.pop();
    }
    }
/**
 * 剪枝
 * 3ms   74%    7.9%   41.6%
 */
    private void dfs1(int n, int k,int start, Deque<Integer> path){
        if(path.size() == k){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i=start;i<=n-(k-path.size())+1;i++){
        path.push(i);
        dfs(n,k,i+1,path);
        path.pop();
    }
    }
}
// @lc code=end

