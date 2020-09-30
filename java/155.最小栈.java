/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
/**
 * 使用双栈，一个存储数据，一个存储当前的最小值，
 * 6ms   98%   8%  40.9MB
 */
class MinStack1 {
Deque<Integer> stack = new LinkedList<>();
Deque<Integer> minStack = new LinkedList<>();
    /** initialize your data structure here. */
    public MinStack1() {

    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.size()==0 || x<=minStack.peek()) minStack.push(x);
    }
    
    public void pop() {
        int top = stack.pop();
        if(top == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
/**
 * 使用栈保存一个长度为2的整数数组，数组第一个元素栈的数据，数组第二个元素是栈当前的最小值
 */
class MinStack {
    Deque<Integer[]> stack = new LinkedList<>();
        /** initialize your data structure here. */
        public MinStack() {
            stack.push(new Integer[]{-1, Integer.MAX_VALUE});
    
        }
        
        public void push(int x) {
            int curMin = Math.min(x,stack.peek()[1]);
            stack.push(new Integer[]{x, curMin});
        }
        
        public void pop() {
            stack.pop();
        }
        
        public int top() {
            return stack.peek()[0];
        }
        
        public int getMin() {
            return stack.peek()[1];
        }
    }
    
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

