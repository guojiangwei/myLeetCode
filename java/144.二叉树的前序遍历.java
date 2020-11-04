/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    private List<Integer> res = new LinkedList<>();
    /**
     * 谦虚遍历递归算法
     * 0ms   100%    64%  36.7MB
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if(root == null)return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;

    }

    /**
     * 迭代算法
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) return res;
            root = stack.pop();
            root = root.right;
        }

    }

    /**
     * 迭代算法2
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            // if(stack.isEmpty()) return res;
            root = stack.pop();
            root = root.right;
        }
        return res;

    }
}
// @lc code=end

