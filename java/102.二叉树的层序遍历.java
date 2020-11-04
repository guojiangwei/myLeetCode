/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<List<Integer>> res = new LinkedList<>();
    /**
     * 递归算法 层次遍历
     * 1ms   92%   62%   38.9MB
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        bfs(root,0);
        return res;
    }
    private void bfs(TreeNode node ,int level ){
        if(node == null)return;
        if(res.size() == level){
            res.add(new LinkedList<Integer>());
        }
        res.get(level).add(node.val);
        bfs(node.left,level+1);
        bfs(node.right,level+1);
    }
/**
 * 队列 迭代
 * 1ms 92%    87%   38.7MB
 */

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> levelRes = new ArrayList<>(queueSize);
            for(int i =0;i<queueSize;i++){
                TreeNode node = queue.poll();
                levelRes.add(node.val);
                if(node.left != null)
                queue.offer(node.left);
                if(node.right != null)
                queue.offer(node.right);
            }
            res.add(levelRes);
        }
        return res;
    }
}
// @lc code=end

