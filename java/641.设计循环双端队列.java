/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
/**
 * 双向循环队列，数组保存
 * 7ms  74.82 %   58%  39.2MB
 */
class MyCircularDeque {
    private int[] elements;
    private int head = 0;
    private int tail = 0;
    private int cap = 0;
    private int len = 0;

    /** Initialize your data structure here. Set the cap of the deque to be k. */
    public MyCircularDeque(int k) {
        cap = k;
        elements = new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())return false;
        head = head==0?cap-1:head-1;
        elements[head] = value;
        len++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())return false;
        elements[tail] = value;
        tail = tail == (cap-1)?0:tail+1;
        len++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        head = head == (cap-1)?0:head+1;
        len--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())return false;
        tail =  tail == 0?(cap-1):tail-1;
        len--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return elements[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        int tailNew = tail == 0?cap-1:tail-1;
        return elements[tailNew];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return len == cap;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

