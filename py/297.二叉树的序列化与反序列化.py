#
# @lc app=leetcode.cn id=297 lang=python3
#
# [297] 二叉树的序列化与反序列化
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

# 递归方法
# 深度优先遍历
# 200ms   23%    5%   23.9MB
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def dfs(node, res):
            if node is None:
                return res + "None,"
            res = res +str(node.val ) + ','
            res = dfs(node.left, res)
            res = dfs(node.right, res)
            return res
        return dfs(root,"")
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        nodes = data.split(',')

        # print(nodes)
        posi = 0
        def dfs():
            nonlocal posi
            if posi == len(nodes):
                return None
            if nodes[posi] == 'None':
                # posi = posi +1
                return None
            # print(posi)
            node = TreeNode(int(nodes[posi]))
            posi = posi +1
            node.left = dfs()
            posi = posi +1
            node.right = dfs()
            return node
        
        
        return dfs()

        
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
# @lc code=end

