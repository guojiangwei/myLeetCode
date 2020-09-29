#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#

# @lc code=start
class Solution:
    #      * 1，从数组的最高位，如果数组元素小于9加一后直接返回数组，如果数组元素等于0，设置为0，并进位
    #  * 2，当数组最高位为9时扩充数组，新数组最高位为1 其余为0
    # 40ms    70%    19%   13.4MB
    def plusOne1(self, digits: List[int]) -> List[int]:
        i = len(digits) - 1
        while i >= 0:
            if digits[i] != 9:
                digits[i] += 1
                return digits
            else:
                digits[i] = 0
            i -= 1
        res = [1] + digits
        return res
# 1，将原始数字数组 连接为字符串
# 2，将字符串转为数字
# 3，数字加一
# 4，将数字转换为字符串
# 5，遍历字符串，并将每个字符转换为数字，加入列表
# 44ms    45%   5%   13.5MB
    def plusOne(self, digits: List[int]) -> List[int]:
        tmp = "".join([str(i) for i in digits])
        tmp = int(tmp) + 1
        res = []
        for d in str(tmp):
            res.append(int(d))
        return res
# @lc code=end

