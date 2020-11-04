/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private LinkedList<Integer> res = new LinkedList<>();
    /**
     * 递归的方式
     * 1ms   96%   78%   39.4MB
     */
    public List<Integer> postorder1(Node root) {
     if(root == null)  return res;
     for(Node node:root.children) postorder(node);
     res.add(root.val);
     return res;
    }

    /**
     * 迭代  
     * 4ms 40%   57%   39.7MB
     * 注意于二叉树的迭代对比
     */
    public List<Integer> postorder(Node root) {
        if(root == null ) return res;
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            res.addFirst(node.val);
            for(Node item : node.children){
                if(item != null){
                    stack.push(item);
                }
            }
        }
        return res;
       }
}
// @lc code=end

