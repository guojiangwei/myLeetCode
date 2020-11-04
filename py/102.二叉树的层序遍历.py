#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 40ms  82%     5%   14.3MB
    def levelOrder1(self, root: TreeNode) -> List[List[int]]:
        res = []
        def bfs(node, level):
            if node is None:
                return
            if len(res) == level:
                res.append([])
            res[level].append(node.val)
            bfs(node.left,level+1)
            bfs(node.right,level+1)
        bfs(root,0)
        return res
# 32ms   98%     13%   13.9MB

    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if root is None:
            return res
        queue = [root]
        while len(queue) !=0:
            queue_size = len(queue)
            level_res = []
            for i in range(queue_size):
                node = queue.pop(0)
                level_res.append(node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            res.append(level_res)
        return res

# @lc code=end

