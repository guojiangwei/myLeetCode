/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 递归，注意左右节点值的判断
     * 6ms   6%    5%   59.2MB
     */
    public int minDepth1(TreeNode root) {
        if(root == null) return 0;
        int leftLevel=Integer.MAX_VALUE,rightLevel=Integer.MAX_VALUE;
        if(root.left == null && root.right == null)return 1;
        if(root.left != null){
            leftLevel = minDepth(root.left);
        }
        if(root.right != null){
            rightLevel = minDepth(root.right);
        }
        return Math.min(leftLevel, rightLevel) + 1;
    }

    //   * 迭代的算法
    //   * 按层次扫描二叉树，最先遇到左右节点都为空的层为最小深度
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levels=0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            levels++;
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                
                if(node.left==null && node.right==null){
                    return levels;
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            
        }

        return levels;
    }
}
// @lc code=end

