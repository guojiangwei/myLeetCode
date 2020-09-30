#
# @lc app=leetcode.cn id=155 lang=python3
#
# [155] 最小栈
#

# @lc code=start
# * 使用双栈，一个存储数据，一个存储当前的最小值，
class MinStack1:

    def __init__(self):
        self.stack = list()
        self.min_stack = list()
        self.min_stack.append(math.inf)
        """
        initialize your data structure here.
        """


    def push(self, x: int) -> None:
        if x <= self.min_stack[-1]:
            self.min_stack.append(x)
        self.stack.append(x)


    def pop(self) -> None:
        if self.stack.pop() == self.min_stack[-1]:
            self.min_stack.pop()
        

    def top(self) -> int:
        return self.stack[-1]


    def getMin(self) -> int:
        return self.min_stack[-1]

# * 使用栈保存一个长度为2的整数数组，数组第一个元素栈的数据，数组第二个元素是栈当前的最小值
# 72ms     94%    5%   16.8MB
class MinStack:

    def __init__(self):
        self.stack = list()
        self.stack.append((-1,math.inf))
        """
        initialize your data structure here.
        """


    def push(self, x: int) -> None:
        cur_min = min(x,self.stack[-1][1])
        self.stack.append((x,cur_min))


    def pop(self) -> None:
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1][0]


    def getMin(self) -> int:
        return self.stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# @lc code=end

