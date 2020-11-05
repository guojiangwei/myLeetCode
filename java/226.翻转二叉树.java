/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
     * 递归算法
     * 0ms    100%    87%    35.9MB
     */
    public TreeNode invertTree1(TreeNode root) {
        dfs(root);
        return root;
    }
    private void dfs(TreeNode node){
        if(node == null) return;
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        dfs(node.left);
        dfs(node.right);
    }

    /**
     * 迭代算法，层次遍历
     * 0ms  100%   90%  35.8MB
     */
    public TreeNode invertTree2(TreeNode root) {
        if(root==null) return root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * 迭代  
     * 深度优先迭代
     * 0ms   100%   86%   35.9MB
     */

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Deque<TreeNode> stack = new LinkedList<>();
        // stack.add(root);
        TreeNode node = root;
        while(node != null ||!stack.isEmpty()){
            
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            node = node.left;
            
        }
        return root;
    }
}
// @lc code=end

