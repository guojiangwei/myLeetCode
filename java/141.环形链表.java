/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * 双指针法,如果存在环，快指针总是可以追上慢指针
     * 0ms  100%   51%   39MB
     */
    public boolean hasCycle1(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        while(fast != null&& fast.next != null){
            if(head == fast) return true;
            head = head.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * hash法，使用set记录访问过的节点，遍历到的节点存在于set中说明存在环
     * 遍历一次链表
     * 7ms   5%    8%   39MB
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针法方法二，循环条件不同,如果存在环，快指针总是可以追上慢指针
     * 0ms  100%   51%   39MB
     */
    public boolean hasCycle3(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        while(fast != head){
            if(fast ==null ||  fast.next==null) return false;
            head = head.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 标记法，访问的的节点给一个固定的值，遍历节点的时候判断该值是否为设置过值，如果设置过说明有环
     * 0ms  100%   51%   39MB
     */
    public boolean hasCycle4(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        while(head != null){
            if(head.val == 100) return true;
            head.val = 100;
            head = head.next;
        }
        return false;
    }

    /**
     * 递归法
     * 0ms  100%   8%   39.5MB
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        if(head.val==100)return true;
        head.val=100;
        return hasCycle(head.next);
    }

}
// @lc code=end

