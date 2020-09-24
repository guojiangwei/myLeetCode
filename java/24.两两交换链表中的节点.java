/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 递归解法
     * 0ms 100% 30%  36.6MB
     */
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next.next;
        ListNode tempHead = head.next;
        head.next.next = head;
        head.next=swapPairs(temp);
        return tempHead;

    }

    /**
     * 迭代解法
     * 0ms 100%  41%  36.6MB
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode newHead=head.next;
        ListNode pre = head;
        while(head != null && head.next!=null){
            ListNode tmp = head.next.next;
            head.next.next = head;
            // if(newHead==null) newHead = head.next;
            pre.next = head.next;
            head.next=tmp;
            pre = head;
            head = tmp;
        }
        return newHead;

    }
    
}
// @lc code=end

