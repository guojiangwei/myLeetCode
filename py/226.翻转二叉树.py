#
# @lc app=leetcode.cn id=226 lang=python3
#
# [226] 翻转二叉树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    #      * 递归算法
    # 32ms     96%     52%    13.4MB
    def invertTree1(self, root: TreeNode) -> TreeNode:
        def dfs(node):
            if node is None:
                return
            tmp = node.left
            node.left=node.right
            node.right=tmp
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        return root

# 迭代，层次交换
# 52ms    9%    9%   13.5MB
    def invertTree2(self, root: TreeNode) -> TreeNode:
        if root is None:
            return root
        stack = [root]
        while len(stack) != 0:
            node = stack.pop()
            if node.left is not None:
                stack.append(node.left)
            if node.right is not None:
                stack.append(node.right)
            node.left, node.right = node.right,node.left
        return root
        # 迭代 ，深度优先
        # 44ms   44%   5%   13.6MB
    def invertTree(self, root: TreeNode) -> TreeNode:
        stack = []
        node = root
        while len(stack) != 0 or node is not None:
            while node is not None:
                stack.append(node)
                node = node.left
            node = stack.pop()
            node.left, node.right = node.right,node.left
            node = node.left
        return root
# @lc code=end

