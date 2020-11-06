/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    /**
     * 递归算法，最简单
     * 0ms   100%    85%    38.5MB
     */
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    /**
     * 迭代的算法
     * 按层次扫描二叉树，最大层数就是数的最大高度
     * 1ms   16%   85%   38.5MB
     */
    public int maxDepth(TreeNode root) {
        
        Deque<TreeNode> stack = new LinkedList<>();
        int levels = 0;
        if(root == null) return levels;
        stack.offer(root);
        while (!stack.isEmpty()){
            int levelSize = stack.size();
            for(int i=0;i<levelSize;i++){
               TreeNode node =  stack.poll();
               if(node.left != null) stack.offer(node.left);
               if(node.right != null) stack.offer(node.right);
            }
            levels++;
        }
        return levels;
    }
}
// @lc code=end

