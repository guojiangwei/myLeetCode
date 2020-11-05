#
# @lc app=leetcode.cn id=589 lang=python3
#
# [589] N叉树的前序遍历
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
    # *递归算法  写法非常简洁
    #  * 
    #  * 56ms     92%     44%   15.3MB
    def preorder1(self, root: 'Node') -> List[int]:
        res = []
        def dfs(node):
            if node is None:
                return
            res.append(node.val)
            for n in node.children:
                dfs(n)
        dfs(root)
        return res

# 迭代算法
# 60ms    82%     7%    15.4MB
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        if root is None:
            return res
        stack = [root]
        while len(stack)!=0:
            node = stack.pop()
            res.append(node.val)
            node.children.reverse()
            for n in node.children:
                stack.append(n)
        return res
        
# @lc code=end

