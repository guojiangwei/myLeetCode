#
# @lc app=leetcode.cn id=145 lang=python3
#
# [145] 二叉树的后序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # 递归算法
    # 44ms   44%   10%  13.5MB
    def postorderTraversal1(self, root: TreeNode) -> List[int]:
        res = []
        def dfs(node):
            if node is None:
                return
            dfs(node.left)
            dfs(node.right)
            res.append(node.val)
        dfs(root)
        return res
# 迭代算法

    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res,stack = [], []
        prev = None
        while root is not None or len(stack) != 0:
            while root is not None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.right is None or root.right == prev:
                res.append(root.val)
                prev = root
                root = None
            else:
                stack.append(root)
                root = root.right
        
        return res
        
# @lc code=end

