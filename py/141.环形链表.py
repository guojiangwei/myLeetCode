#
# @lc app=leetcode.cn id=141 lang=python3
#
# [141] 环形链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # 双指针法,如果存在环，快指针总是可以追上慢指针
    # 72MS   24.4%   85%   16.2MB
    def hasCycle1(self, head: ListNode) -> bool:
        if head is None:
            return False
        fast = head.next
        while fast is not None and fast.next is not None:
            if fast == head:
                return True
            head = head.next
            fast = fast.next.next
        return False
    # 双指针法二 不同的循环条件,如果存在环，快指针总是可以追上慢指针
    # 60MS   76.4%   60%   16.3MB
    def hasCycle2(self, head: ListNode) -> bool:
        if head is None:
            return False
        fast = head.next
        while fast != head:
            if fast is None or fast.next is None:
                return False
            head = head.next
            fast = fast.next.next
        return True
    
    # hash法 使用set记录访问过的节点，遍历到的节点存在于set中说明存在环
    # 72MS   24.4%   10%   16.7MB
    def hasCycle3(self, head: ListNode) -> bool:
        visited_node = set()
        while head is not None:
            if head in visited_node:
                return True
            visited_node.add(head)
            head = head.next
        return False
    
    # * 标记法，访问的的节点给一个固定的值，遍历节点的时候判断该值是否为设置过值，如果设置过说明有环
    # 76ms  17%    99%   15.9MB

    def hasCycle4(self, head: ListNode) -> bool:
        while head is not None:
            if head.val == 100:
                return True
            head.val = 100
            head = head.next
        return False
    # 递归法
    # 100ms    6%  5%   20.8MB
    def hasCycle(self, head: ListNode) -> bool:
        if head is None:
            return False
        if head.val == 100:
            return True
        head.val = 100
        return self.hasCycle(head.next)

        
# @lc code=end

