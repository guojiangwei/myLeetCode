#
# @lc app=leetcode.cn id=142 lang=python3
#
# [142] 环形链表 II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # hash法，访问的节点val设置为最大值，当遇到值为最大值的节点时就是循环指针的入口节点
    # 64ms 68%  5%  16.9MB
    def detectCycle2(self, head: ListNode) -> ListNode:
        visited_node = set()
        while head is not None:
            if head in visited_node:
                return head
            visited_node.add(head)
            head = head.next
        return None

#  * Floyd 算法，
#  * 1，保存头指针位置
#  * 2，用双指针法判断是否存在环并得出相遇点，
#  * 3，头指针与相遇点同步前进，相遇时就是环的入口节点
#  * 该算法需要注意fast 和slow的起始节点位置
#  * 60ms    84%     67%   16.3MB
    def detectCycle(self, head: ListNode) -> ListNode:
        if head is None:
            return head
        fast = head.next
        first = head
        while fast != head:
            if fast is None or fast.next is None:
                return None
            fast = fast.next.next
            head = head.next
        fast = fast.next
        while fast != first:
            fast = fast.next
            first = first.next 
        return fast
        
# @lc code=end

