

# @lc code=start
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
    def __str__(self):
        str_res = str(self.val)
        if self.left is not None:
            str_res = str_res +" " + str(self.left)+" "
        else:
            str_res = str_res +" " + "None "
        if self.right is not None:
            str_res =  str_res+" "+str(self.right)+" "
        else:
            str_res =  str_res+"None "
        return str_res

class Codec:

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

        print(nodes)
        posi = 0
        def dfs():
            nonlocal posi
            if posi == len(nodes):
                return None
            if nodes[posi] == 'None':
                # posi = posi +1
                return None
            print(posi)
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


if __name__ == "__main__":
    code = Codec()
    
    root = TreeNode(5)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.right.left = TreeNode(3)
    root.right.right = TreeNode(6)
    
    print(code.serialize(root))
    print(code.deserialize(code.serialize(root)))