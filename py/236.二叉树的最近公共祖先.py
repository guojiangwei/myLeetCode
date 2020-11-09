#
# @lc app=leetcode.cn id=236 lang=python3
#
# [236] 二叉树的最近公共祖先
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 72ms   97%   9%   26.8MB
    def lowestCommonAncestor1(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        res = None
        def dfs(node):
            nonlocal res
            if node is None:
                return False
            lson = dfs(node.left)
            rson = dfs(node.right)
            if(lson and rson or((node.val == p.val or node.val==q.val) and (lson or rson))):
                res = node
                print("res:"+str(res.val))
            return lson or rson or (node.val == p.val or node.val == q.val)
        dfs(root)
        print(res.val)
        return res

# 92ms   53%   5%   28.6MB
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        parent = {}
        visited = {}
        def dfs(node):
            if node is None:
                return
            if node.left is not None:
                parent[node.left.val] = node
                dfs(node.left)
            if node.right is not None:
                parent[node.right.val] = node
                dfs(node.right)

        dfs(root)
        while p is not None:
            visited[p.val] = p.val
            p = parent.get(p.val,None)
        while q is not None:
            if visited.get(q.val,None) is not None:
                return q
            q = parent[q.val]
        return None


        
# @lc code=end

