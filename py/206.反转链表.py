#
# @lc app=leetcode.cn id=206 lang=python3
#
# [206] 反转链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # * 递归的方式,python嵌套函数很适合写递归
    # 36ms   97.5 %    5.02 %   19.3 MB
    # 
    def reverseList1(self, head: ListNode) -> ListNode:
        reverse_head = None
        if head is None:
            return None
        def recusion(node):
            if node.next is None:
                nonlocal reverse_head 
                reverse_head = node
                return node
            next = recusion(node.next)
            node.next = next.next
            next.next = node
            return node
        recusion(head)
        return reverse_head
# 循环方式，用了Python特有的交换变量的方法，省略的Java的中间变量
# 50ms 30%    87%   14.2MB
    def reverseList2(self, head: ListNode) -> ListNode:
        cur,node = head,None
        while cur is not None:
            node,cur.next, cur = cur,node,cur.next
        return node

    # * 递归的方式,python嵌套函数很适合写递归
    # 44ms   44 %    9.02 %   18.1 MB
    # 
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        node = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return node
# @lc code=end

