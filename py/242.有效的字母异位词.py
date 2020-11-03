#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
class Solution:
    # python更简洁的排序算法
    # 56ms   75%    16%  14.4MB
    def isAnagram1(self, s: str, t: str) -> bool:
        s1 = sorted(s)
        t1 = sorted(t)
        return s1 == t1

# 字典
# 64ms   52%   33%    13.7MB
    def isAnagram2(self, s: str, t: str) -> bool:
        dict1 = {}
        dict2 = {}
        for item in s:
            dict1[item] = dict1.get(item,0) + 1
        for item in t:
            dict2[item] = dict2.get(item,0) + 1
        return dict1 == dict2

#  * 1，创建一个26长度的数组result，
#  * 2，s和t数组中的字符减去'a' 得出下标
#  * 3，数据对应s的下标加1，
#  * 4，数组对应t产生的下标减1
#  * 5，遍历数组result，如果result中都是0 返回true 否则返回false
# 52ms 84%   42%   13.6MB
    def isAnagram3(self, s: str, t: str) -> bool:
        
        if len(s) != len(t):
            return False
        aindex = ord('a')
        list1 = [0] * 26
        for i in range(len(t)):
            list1[ord(s[i])-aindex] += 1
            list1[ord(t[i])-aindex] -= 1
        for i in list1:
            if i != 0:
                return False
        return True
# 跟用一个数组遍历时间差不多 跟方法3 差不多，就是写的比较容易阅读
# 52ms   84%    37%    13.6MB
    def isAnagram(self, s: str, t: str) -> bool:
        
        if len(s) != len(t):
            return False
        aindex = ord('a')
        list1 = [0] * 26
        list2 = [0] * 26
        for item in s:
            list1[ord(item)-aindex] += 1
        for item in t:
            list2[ord(item)-aindex] += 1
        return list1 == list2
# @lc code=end

