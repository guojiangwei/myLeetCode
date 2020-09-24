#
# @lc app=leetcode.cn id=24 lang=python3
#
# [24] 两两交换链表中的节点
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    #      递归解法
    # 40ms 75%  26%  13.4MB
    def swapPairs1(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        tmp = head.next.next
        head.next.next = head
        res = head.next
        head.next = self.swapPairs(tmp)
        return res
    
    # 迭代解法
    # 40ms   75%    6%    13.5MB
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        pre,res = head,head.next
        while head is not None and head.next is not None:
            tmp = head.next.next
            pre.next = head.next
            head.next.next = head
            pre = head
            head.next = tmp
            head = tmp
        return res

# @lc code=end

