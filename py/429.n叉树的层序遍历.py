#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    # 递归算法
    # 64MS  67%   34.6%   15.3MB
    def levelOrder1(self, root: 'Node') -> List[List[int]]:
        res = []
        def bfs(node,level):
            if node is None:
                return
            if(len(res)==level):
                res.append([])
            res[level].append(node.val)
            for n in node.children :
                bfs(n, level+1)
        bfs(root,0)
        return res

# 迭代 队列
# 64ms   67%   32%  15.3MB
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        res = []
        if root is None:
            return res
        queue = [root]
        while len(queue) !=0:
            row_size = len(queue)
            row_res = []
            for i in range(row_size):
                node = queue.pop(0)
                row_res.append(node.val)
                for n in node.children:
                    queue.append(n)
            res.append(row_res)
        return res

        
# @lc code=end

