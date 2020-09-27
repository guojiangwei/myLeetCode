#
# @lc app=leetcode.cn id=21 lang=python3
#
# [21] 合并两个有序链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    #      * 新建一个空虚拟头结点
    #  * 将l1 和l2中较小的节点链接到虚拟空节点
    #  * 返回虚拟空节点的下一个节点
    # 48ms   72%    44%   13.4MB
    def mergeTwoLists1(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy_head = ListNode()
        begin = dummy_head
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                begin.next = l1
                l1 = l1.next
                
            else:
                begin.next = l2
                l2 = l2.next
            begin = begin.next
        if l1 is not None:
            begin.next = l1
        if l2 is not None:
            begin.next = l2
        return dummy_head.next
        # * 使用递归
        # 性能跟上面类似
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
# @lc code=end

