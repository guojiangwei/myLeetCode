/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    ListNode reverseHead;
    /**
     * 递归的方式
     * 0ms 100 %    5.28 %   39.1 MB
     */
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode next = reverseList(head.next);
        head.next.next=head;
        head.next = null;
        return next;
    }
    // ListNode recusion1(ListNode head){
    //     if(head.next == null){
    //         reverseHead = head;
    //         return head;
    //     }
    //     ListNode next = recusion1(head.next);
    //     head.next=next.next;
    //     next.next = head;
    //     return head;
    // }

    /**
     * 递归的方式,另外一个递归逻辑，没有上面的递归代码简洁 主方法里面减少一个判断语句
     * 可以看到在主方法里面先判断一次head是否为空 代码更简洁
     * 0ms 100 %    5.28 %   39.1 MB
     */
    public ListNode reverseList2(ListNode head) {
        recusion(head);
        return reverseHead;
    }
    ListNode recusion(ListNode head){
        if(head == null){
            return head;
        }

        ListNode next = recusion(head.next);
        if(next == null){
            reverseHead = head;
            return head;
        }
        head.next=next.next;
        next.next = head;
        return head;
    }
/**
 * 循环的方式
 * 0ms   100%    18.76%    39MB
 */
    public ListNode reverseList3(ListNode head) {
        ListNode  node = null;
        ListNode  cur = head;

        while(cur != null){
            // reverseHead = head;
            ListNode  tmp = cur.next;
            cur.next = node;
            node = cur;
            cur = tmp;
        }
        return node;
    }
}
// @lc code=end

