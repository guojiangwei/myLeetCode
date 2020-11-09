/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    private Map<Integer,Integer> inorderMap = new HashMap<>();
    /**
     * 4ms    47%    94%    38.4MB
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if(preorder.length ==0 ) return null;
        // TreeNode root = new TreeNode(preorder[0]);
        return dfs(preorder,inorder,0,preorder.length-1,0,preorder.length-1);
    }
    private TreeNode dfs(int[] preorder, int[] inorder,int prePosition,int endPrePosition, int inStartPosi,int inEndPosi){
        if(prePosition>endPrePosition ) return null;
        int inRoot = inStartPosi;
        TreeNode root = new TreeNode(preorder[prePosition]);
        while(preorder[prePosition] != inorder[inRoot] && inRoot != inEndPosi) inRoot++;
        if(inRoot!=inStartPosi)
        root.left = dfs(preorder,inorder,prePosition+1,prePosition+inRoot-inStartPosi,inStartPosi,inRoot-1);

        if(inRoot!=inEndPosi)
        root.right = dfs(preorder,inorder,prePosition+inRoot-inStartPosi+1,endPrePosition,inRoot+1,inEndPosi);
        return root;
    }


        /**
     * 3ms    47%    94%    38.4MB
     * 跟方法一大体一样，不同点就是再用前序节点值再中序查找位置
     * 方法一使用数组遍历
     * 本方法使用map将中序的值和位置保存起来，效率比较高。
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder.length ==0 ) return null;
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        // TreeNode root = new TreeNode(preorder[0]);
        return dfs2(preorder,inorder,0,preorder.length-1,0,preorder.length-1);
    }
    private TreeNode dfs2(int[] preorder, int[] inorder,int prePosition,int endPrePosition, int inStartPosi,int inEndPosi){
        if(prePosition>endPrePosition ) return null;
        int inRoot = inStartPosi;
        TreeNode root = new TreeNode(preorder[prePosition]);
        // while(preorder[prePosition] != inorder[inRoot] && inRoot != inEndPosi) inRoot++;
        inRoot = inorderMap.get(preorder[prePosition]);
        if(inRoot!=inStartPosi)
        root.left = dfs2(preorder,inorder,prePosition+1,prePosition+inRoot-inStartPosi,inStartPosi,inRoot-1);

        if(inRoot!=inEndPosi)
        root.right = dfs2(preorder,inorder,prePosition+inRoot-inStartPosi+1,endPrePosition,inRoot+1,inEndPosi);
        return root;
    }
/**
 * 迭代算法
 * 2ms   97%   99%   38%
 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length ==0 || preorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        
        
            
            for(int i=1;i<preorder.length;i++){
                int preorderVal = preorder[i];
                TreeNode node = stack.peek();
                if(node.val != inorder[inorderIndex]){
                    node.left = new TreeNode(preorderVal);
                    stack.push(node.left);
                }else{
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                        node = stack.pop();
                        inorderIndex++;
                    }
                    node.right = new TreeNode(preorderVal);
                    stack.push(node.right);
    
                }
            }

        
        // TreeNode root = new TreeNode(preorder[0]);
        return root;
    }
}
// @lc code=end

