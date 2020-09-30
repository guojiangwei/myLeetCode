#
# @lc app=leetcode.cn id=20 lang=python3
#
# [20] 有效的括号
#

# @lc code=start
class Solution:
    # 1，用栈存放左括号
    #  * 2，用map存放合法的括号对，键存右括号，值存左括号
    #  * 3，扫描字符串，当扫描到左括号是入栈，扫描到右括号是判断栈顶是否是合肥的左括号
    # 注意stack = list()比stack=[]快
    # 32ms    97%    76%   13.3MB
    def isValid1(self, s: str) -> bool:
        stack = list()
        parentheses_map = {')':'(',']':'[','}':'{'}
        for c in s:
            if parentheses_map.get(c, None) is  None:
                stack.append(c)
            elif len(stack)==0:
                return False
            elif parentheses_map[c] != stack.pop() :
                return False
        return len(stack) == 0
        # 跟方法1一样，只是判断条件不一样
    def isValid2(self, s: str) -> bool:
        stack = list()
        parentheses_map = {')':'(',']':'[','}':'{'}
        for c in s:
            if c in parentheses_map:
                if len(stack) == 0:
                    return False
                if parentheses_map[c] != stack.pop():
                    return False
            else:
                stack.append(c)
        return len(stack) == 0
    #  * 1，栈结构不变
    #  * 2，使用判断语句代替map
    #  * 此例判断语句写的很繁琐，不容易看懂
    # 40ms  50%   60%   13.4MB
    def isValid(self, s: str) -> bool:
        stack = list()
        for c in s:
            if c == '(':
                stack.append(')')
            elif c == '[':
                stack.append(']')
            elif c == '{':
                stack.append('}')
            elif len(stack) == 0 or stack.pop() != c:
                return False
        return len(stack) == 0

# @lc code=end

