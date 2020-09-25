/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
     * 用递归的方式批量跳跃节点
     * 每k个节点使用循环翻转链表，
     * 每次翻转链表前统计链表的节点数量，如果数量不够不执行翻转
     * 0ms    100%   27%   39.2MB
     */

    public ListNode reverseKGroup1(ListNode head, int k) {
        if(head == null)return head;
        ListNode pre = null;
        ListNode first = head;
        // 统计节点数够不够
        int i = 0;

        while(head!=null){
            i++;
            head = head.next;
        }
        // 还原head的值
        head = first;
        // 如果节点数不够 返回当前的次序
        if(i <k)return head;
        // 如果节点数够，执行翻转操作
        for( i=0;i<k && head !=null;i++){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        first.next = reverseKGroup(head,k);
        return pre;
    }



    /**
     * 双循环
     * 每k个节点使用循环翻转链表，
     * 每次翻转链表前统计链表的节点数量，如果数量不够不执行翻转
     * 1ms    41%   5%   39.4MB
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==1)return head;
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        ListNode begin = dummyHead;
        // 统计节点数够不够
        int i = 0;

        while(head!=null){
            i++;
            if(i%k == 0){
                // begin = begin.next;
                // head = head.next;
                ListNode cur = begin.next;
                ListNode first = cur;
                ListNode next = null;
                ListNode pre = begin;
                ListNode tmp = head.next;
                while(cur != tmp){
                    next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                begin.next = pre;
                head = cur;
                first.next = cur;
                begin = first;
            }else head = head.next;
        }
        return dummyHead.next;
    }
}
// @lc code=end

