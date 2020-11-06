#
# @lc app=leetcode.cn id=104 lang=python3
#
# [104] 二叉树的最大深度
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    #    * 递归算法，最简单
    # 44ms   96%   11%  15.5MB
    def maxDepth1(self, root: TreeNode) -> int:
        if  root is None:
            return 0
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

    #  * 迭代的算法
    #  * 按层次扫描二叉树，最大层数就是数的最大高度
    # 48ms   88%   80%   14.7MB
    def maxDepth(self, root: TreeNode) -> int:
        if  root is None:
            return 0
        levels = 0
        queue = [root]
        while len(queue) !=0:
            level_size = len(queue)
            for i in range(level_size):
                node = queue.pop(0)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
                
            levels += 1
        return levels

        
# @lc code=end

