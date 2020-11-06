/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    private List<Integer> travelResult = new LinkedList<>();

    /**
     * 使用数组保存中序遍历的结果，在遍历数组判断数组是不是升序排列
     * 109ms   5%    38.5MB
     */
    public boolean isValidBST1(TreeNode root) {
        // if(root == null) return false;
        inOrderDfs(root);
        // if(travelResult.size() == 0 ) return false;
        if(travelResult.size() <= 1 ) return true;
        for(int i=1;i<travelResult.size();i++){
            if(travelResult.get(i-1)>= travelResult.get(i)) return false;
        }
        return true;
    }

    private void inOrderDfs(TreeNode node){
        if(node == null)return;
        inOrderDfs(node.left);
        travelResult.add(node.val);
        inOrderDfs(node.right);
    }


    /**
     * 迭代判断
     * 中途就可以判断是不是二叉排序树，不用遍历整个书，跟方法一对比也不用保存全部节点
     * 2ms    31%     81%   38.3MB
     */
    public boolean isValidBST2(TreeNode root) {
        // if(root == null) return false;
        double inOrder = -Double.MAX_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= inOrder ){
                return false;
            }
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }


    /**
     * 递归算法
     * 减枝算法
     * 1ms    35%     85%    38.2MB
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null,null);
    }
    private boolean helper(TreeNode node, Integer lower,Integer upper){
        if(node ==null) return true;

        int val = node.val;
        if( lower!=null && val >= lower){
            return false;
        }

        if(upper!=null && val <= upper){
            return false;
        }

        if(!helper(node.left,val,upper)){
            return false;
        }

        if(!helper(node.right,lower,val)){
            return false;
        }
        return true;
    }
}
// @lc code=end

