/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 新建一个空虚拟头结点
     * 将l1 和l2中较小的节点链接到虚拟空节点
     * 返回虚拟空节点的下一个节点
     * 0ms 100%    50%  38.5MB
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null)  cur.next = l1;
        
        if(l2 != null) cur.next = l2;

        return dummyHead.next;
        
    }
    /**
     * 使用递归
     * 2ms  100%   30%   38.6MB
     * 
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
// @lc code=end

