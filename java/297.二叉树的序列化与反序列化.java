/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

// Encodes a tree to a single string.
/**
 * 迭代
 * 24ms  52%    97%   39.8MB
 */
public String serialize(TreeNode root) {
    StringBuilder res = new StringBuilder("");
    if(root == null) return res.toString();
    Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        int levelSize = queue.size();
        for(int i=0;i<levelSize;i++){
            TreeNode node = queue.poll();
            if(node == null){
                res.append("null");
            }
            else {
                res.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            res.append(",");
        }
    }
    return res.deleteCharAt(res.length()-1).toString();
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {

    if(data.length()==0) return null;
    String[] nodes = data.split(",");
    TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
    if(nodes.length == 0) return root;
    int nodeIndex =1;

    Deque<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while( !queue.isEmpty() && nodeIndex < data.length()){
        int levelSize = queue.size();

        for(int i=0;i<levelSize;i++){
            TreeNode node = queue.poll();
            if(!nodes[nodeIndex] .equals("null") ){
                TreeNode newNode = new TreeNode(Integer.valueOf(nodes[nodeIndex]));
                node.left = newNode;
                queue.offer(newNode);
            }
            nodeIndex++;
            if(!nodes[nodeIndex].equals("null") ){
                TreeNode newNode = new TreeNode(Integer.valueOf(nodes[nodeIndex]));
                node.right = newNode;
                queue.offer(newNode);
            }
            nodeIndex++;
        }
    }
    return root;
}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

