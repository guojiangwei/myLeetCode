/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
    private List<Integer> res = new LinkedList<>() ;
    /**递归算法  写法非常简洁
     * 
     * 1ms     95%     54%   39.6MB
     */
    public List<Integer> preorder1(Node root) {
        if(root == null)return res;
        res.add(root.val);
        for(Node node:root.children) preorder(node);
        return res;
    }

        /**迭代算法  写法非常简洁
     * 
     * 4ms     15%     39%   39.7MB
     */
    public List<Integer> preorder(Node root) {
        Deque<Node> stack = new LinkedList<>();
        if(root == null) return res;
        stack.add(root);
        while ( !stack.isEmpty()){
            
            Node node = stack.pollLast();
            res.add(node.val);
            Collections.reverse(node.children);
            for(Node n : node.children){
                stack.add(n);
            }
        }
        return res;
    }
}
// @lc code=end

