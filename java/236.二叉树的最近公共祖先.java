/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
    private TreeNode res;
    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    /**
     * 深度遍历查找左右子节点是否包含给点节点
     * 如果左右节点包含给定的节点，说明是最小祖先
     * 8ms   57%   67%  40.8MB
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;
        if(res != null) return false;
        
        boolean lson = (dfs(node.left,p,q));
        boolean rson = dfs(node.right, p, q);
        if( lson && rson ||((node.val == p.val || node.val ==q.val) && (lson || rson))){
            res = node;
        }
        return lson || rson || (node.val == q.val || node.val == p.val);
    }

    private void parentDfs(TreeNode root){
        if(root == null)return;
        if(root.left != null){
            parent.put(root.left.val,root);
            parentDfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val,root);
            parentDfs(root.right);
        }
    }
    /**
     * 深度优先遍历，用map报错所有节点的父节点信息<node.val,node.parent>
     * 将访问的过节点放到set中，获取p的父节点信息，一直到根节点
     * 从map中获取q的父节点信息，并判断是否已经访问过，如果访问过就是最近祖先
     * 12ms   15%    5%   41.8MB
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parentDfs(root);
        while(p !=null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while(q != null){
            if (visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
// @lc code=end

