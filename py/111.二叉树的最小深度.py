#
# @lc app=leetcode.cn id=111 lang=python3
#
# [111] 二叉树的最小深度
#
import collections
# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # * 递归，注意左右节点值的判断
    # 696ms  5%    5%  52.8MB
    def minDepth1(self, root: TreeNode) -> int:
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1
        right_levels,left_levels = float("inf"),float("inf")
        if root.left is not None:
            left_levels = self.minDepth(root.left)
        if root.right is not None:
            right_levels = self.minDepth(root.right)
        return min(right_levels, left_levels) + 1

# * 迭代的算法
# * 按层次扫描二叉树，最先遇到左右节点都为空的层为最小深度
# 440ms   8%    5%  49.2MB
    def minDepth2(self, root: TreeNode) -> int:
        if root is None:
            return 0
        queue = [root]
        levels = 0
        while len(queue) != 0:
            level_size = len(queue)
            levels += 1
            for i in range(level_size):
                node = queue.pop(0)
                if node.left is None and node.right is None:
                    return levels
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
        return  levels

    def minDepth3(self, root: TreeNode) -> int:
        if root is None:
            return 0
        queue = collections.deque()
        queue.append(root)
        levels = 0
        while len(queue) != 0:
            level_size = len(queue)
            levels += 1
            for i in range(level_size):
                node = queue.popleft()
                if node.left is None and node.right is None:
                    return levels
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
        return  levels

    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0

        que = collections.deque([(root, 1)])
        while que:
            node, depth = que.popleft()
            if not node.left and not node.right:
                return depth
            if node.left:
                que.append((node.left, depth + 1))
            if node.right:
                que.append((node.right, depth + 1))
        
        return 0


# @lc code=end

