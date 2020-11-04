#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # 递归调用，中序遍历
    # 32ms   96%   5%  13.5MB
    def inorderTraversal1(self, root: TreeNode) -> List[int]:
        res = []
        def dfs(node):
            if node is None:
                return
            dfs(node.left)
            res.append(node.val)
            dfs(node.right)
        dfs(root)
        return res
    # 中序遍历的迭代算法
    # 32ms   96%   5%  13.5MB
    def inorderTraversal2(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        while root is not None or len(stack) != 0:
            while root is not None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            res.append(root.val)
            root = root.right
        return res
    
    # 迭代算法，不同的循环条件
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []
        while True:
            while root is not None:
                stack.append(root)
                root = root.left
            if len(stack) == 0:
                return res
            root = stack.pop()
            res.append(root.val)
            root = root.right
        return res
        
# @lc code=end

