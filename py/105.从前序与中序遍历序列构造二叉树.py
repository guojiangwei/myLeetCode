#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] 从前序与中序遍历序列构造二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 388 7%    71%   18.1MB
    def buildTree1(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def dfs(start_preorder_posi,end_preorder_posi,start_inorder_posi,end_inorder_posi):
            if start_preorder_posi > end_preorder_posi :
                return None
            inroot = start_inorder_posi
            root = TreeNode(preorder[start_preorder_posi])
            while(preorder[start_preorder_posi]!=inorder[inroot] and inroot != end_inorder_posi):
                inroot += 1
            if inroot != start_inorder_posi:
                root.left = dfs(start_preorder_posi+1,end_preorder_posi+inroot-start_inorder_posi,start_inorder_posi,inroot-1)
            if inroot != end_inorder_posi:
                root.right = dfs(start_preorder_posi+inroot-start_inorder_posi+1,end_preorder_posi,inroot+1,end_inorder_posi)
            return root
        if preorder is None or len(preorder) ==0:
            return None
        return dfs(0,len(preorder)-1,0,len(inorder)-1)
     
    #  * 跟方法一大体一样，不同点就是再用前序节点值再中序查找位置
    #  * 方法一使用数组遍历
    #  * 本方法使用map将中序的值和位置保存起来，效率比较高。
    # 44ms   98%   67%   18.5MB
    def buildTree2(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        in_map = {val:key for key,val in enumerate(inorder)}
        def dfs(start_preorder_posi,end_preorder_posi,start_inorder_posi,end_inorder_posi):
            if start_preorder_posi > end_preorder_posi :
                return None
            inroot = in_map.get(preorder[start_preorder_posi])
            root = TreeNode(preorder[start_preorder_posi])
            # while(preorder[start_preorder_posi]!=inorder[inroot] and inroot != end_inorder_posi):
            #     inroot += 1
            if inroot != start_inorder_posi:
                root.left = dfs(start_preorder_posi+1,end_preorder_posi+inroot-start_inorder_posi,start_inorder_posi,inroot-1)
            if inroot != end_inorder_posi:
                root.right = dfs(start_preorder_posi+inroot-start_inorder_posi+1,end_preorder_posi,inroot+1,end_inorder_posi)
            return root
        if preorder is None or len(preorder) ==0:
            return None
        return dfs(0,len(preorder)-1,0,len(inorder)-1)

# 49ms    95    97%   14.5MB
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        if preorder is None or len(preorder) ==0:
            return None
        root = TreeNode(preorder[0])
        stack = [root]
        in_index = 0
        for i in range(1,len(preorder)):
            node = stack[-1]
            pre_val = preorder[i]
            if node.val != inorder[in_index]:
                node.left = TreeNode(pre_val)
                stack.append(node.left)
            else:
                while len(stack) !=0 and stack[-1].val == inorder[in_index]:
                    node = stack.pop()
                    in_index += 1
                node.right = TreeNode(pre_val)
                stack.append(node.right)
        return root
                

# @lc code=end

