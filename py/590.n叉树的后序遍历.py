#
# @lc app=leetcode.cn id=590 lang=python3
#
# [590] N叉树的后序遍历
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
    # 递归的方式
    # 88ms    7%    32%     15.3MB
    def postorder1(self, root: 'Node') -> List[int]:
        res = []
        def dfs(node):
            if node is None:
                return
            for n in node.children:
                dfs(n)
            res.append(node.val)
        dfs(root)
        return res
    
    # 68ms  46%   10%   15.4MB
    def postorder(self, root: 'Node') -> List[int]:
        res,stack = [],[root]
        if root is None:
            return res
        while len(stack) !=0:
            node = stack.pop()
            res.insert(0,node.val)
            for n in node.children:
                stack.append(n)
        return res
        
# @lc code=end

