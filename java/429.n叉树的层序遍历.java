/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
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
    private List<List<Integer>> res = new LinkedList<>() ;
    /**
     * 递归算法
     * 1ms   100%   82%   39.5MB
     */
    public List<List<Integer>> levelOrder1(Node root) {
        bfs(root,0);
        return res;
    }
    private void bfs(Node node,int level){
        if(node == null)return;
        if(res.size()==level){
            res.add(new LinkedList<Integer>());
        }
        res.get(level).add(node.val);
        for(Node n : node.children)bfs(n,level+1);
    }

    /**
     * 迭代算法，
     * 4ms   54%   76%   39.5MB
     */
    public List<List<Integer>> levelOrder(Node root) {
        if(root ==null) return  res;
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int rowSize = queue.size();
            List<Integer> levelRes = new ArrayList<>(rowSize);
            for(int i=0;i<rowSize;i++){
                Node node = queue.poll();
                levelRes.add(node.val);
                for(Node n:node.children){
                    queue.offer(n);
                }
            }
            res.add(levelRes);
        }
        return res;
    }
}
// @lc code=end

