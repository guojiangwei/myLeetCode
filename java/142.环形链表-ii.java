/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
     * 标记法，访问的节点val设置为最大值，当遇到值为最大值的节点时就是循环指针的入口节点
     */
    public ListNode detectCycle1(ListNode head) {
        if(head ==null) return head;
        head.val=0;
        ListNode first = head;
        // head = head.next;
        
        while(head != null){
            if( head.val == Integer.MAX_VALUE) return head;
            head.val=Integer.MAX_VALUE;
            head = head.next;
        }
        return null;
    }

    /**
     * hash法，访问的节点val设置为最大值，当遇到值为最大值的节点时就是循环指针的入口节点
     * 5ms 20%  15%  39.8MB
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if( set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }
/**
 * Floyd 算法，
 * 1，保存头指针位置
 * 2，用双指针法判断是否存在环并得出相遇点，
 * 3，头指针与相遇点同步前进，相遇时就是环的入口节点
 * 该算法需要注意fast 和slow的起始节点位置
 * 1ms    38%     35%   39.1
 */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;
        // 双指针求出相遇点
        ListNode first = head;
        ListNode fast = head.next;
        while(fast !=head){
            if(fast == null || fast.next ==null){
                return null;
            }
            head = head.next;
            fast = fast.next.next;
        }
        fast = fast.next;
        while(fast!=first){
            fast = fast.next;
            first = first.next;
            
        }
        return fast;
    }
}
// @lc code=end

