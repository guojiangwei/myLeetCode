#
# @lc app=leetcode.cn id=98 lang=python3
#
# [98] 验证二叉搜索树
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 迭代算法
    # * 使用数组保存中序遍历的结果，在遍历数组判断数组是不是升序排列
    # 52ms   86%   7%   16.5MB
    def isValidBST1(self, root: TreeNode) -> bool:
        travel_res = []
        def dfs(node):
            if node is None:
                return
            dfs(node.left)
            travel_res.append(node.val)
            dfs(node.right)
        dfs(root)
        if len(travel_res) <= 1:
            return True
        for i in range(1,len(travel_res)):
            if travel_res[i]<= travel_res[i-1]:
                return False
        return True

    #  迭代算法
    # 中途就可以判断是不是二叉排序树，不用遍历整个书，跟方法一对比也不用保存全部节点
# 实际效果看起来，Python递归比迭代效率高
# 196ms    6%    33%   16MB
    def isValidBST2(self, root: TreeNode) -> bool:
        travel_res = []
        inorder = float('-inf')
        while root is not None or len(travel_res) != 0:
            while root is not None:
                travel_res.append(root)
                root = root.left
            root = travel_res.pop()
            if root.val <= inorder:
                return False
            inorder = root.val
            root = root.right

        return True

# 递归算法比递归算法1更好 但是从效率上没看出来
# 60ms   49%   42%    15.8MB
    def isValidBST(self, root: TreeNode) -> bool:
        travel_res = []
        def dfs(node,lower,upper):
            if node is None:
                return True
            val = node.val
            if(lower is not None and val >= lower):
                return False
            if(upper is not None and val <= upper):
                return False
            if not dfs(node.left,val,upper):
                return False
            if not dfs(node.right,lower,val):
                return False
            return True
        return dfs(root,None,None)

# @lc code=end

