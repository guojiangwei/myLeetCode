#
# @lc app=leetcode.cn id=25 lang=python3
#
# [25] K 个一组翻转链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:

    #  * 用递归的方式批量跳跃节点
    #  * 每k个节点使用循环翻转链表，
    #  * 每次翻转链表前统计链表的节点数量，如果数量不够不执行翻转
    #  * 56ms    70%   19%   14.2MB
     
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if head is None:
            return head
        pre = None
        first = head

        # 统计节点数量，如果节点数量小于k返回
        i = 0
        while head is not None:
            i += 1
            head = head.next
        head = first
        if i<k:
            return head

        #用循环翻转k个节点
        for i in range(k):
            tmp = head.next 
            head.next = pre
            pre = head
            head = tmp
        first.next = self.reverseKGroup(head,k)
        return pre
    #  * 双循环
    #  * 每k个节点使用循环翻转链表，
    #  * 每次翻转链表前统计链表的节点数量，如果数量不够不执行翻转
    # 56ms 50%  56% 14.1
    def reverseKGroup2(self, head: ListNode, k: int) -> ListNode:
        if head is None or k == 1:
            return head
        dummy_head = ListNode(-1)
        dummy_head.next = head
        begin = dummy_head
        i = 0
        while head is not None:
            i += 1
            if(i%k == 0):
                cur = begin.next
                first = cur
                pre = begin
                tmp = head.next
                while cur != tmp:
                    next = cur.next
                    cur.next = pre
                    pre = cur
                    cur = next
                first.next = cur
                begin.next = pre
                head = cur
                begin = first
            else:
                head= head.next
        return dummy_head.next

# @lc code=end

