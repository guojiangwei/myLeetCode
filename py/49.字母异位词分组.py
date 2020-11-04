#
# @lc app=leetcode.cn id=49 lang=python3
#
# [49] 字母异位词分组
#
import collections
# @lc code=start
class Solution:
    # #* 1,遍历字符串数组
    #  * 2，为每个字符串排序
    #  * 3，以排序后的字符串为key，放入字典中，字典的value为存放字符串list
    #  * 4，map的value转换为list集合
    # 60ms    73%    29%   16.9MB
    def groupAnagrams1(self, strs: List[str]) -> List[List[str]]:
        res_map = {}
        for str in strs:
            key = tuple(sorted(str))
            if res_map.get(key,None) is None:
                res_map[key] = []
            res_map[key].append(str)
        return [i for i in res_map.values()]

# 跟方法一一样，采用了collections api
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res_map = collections.defaultdict(list)
        for str in strs:
            key = tuple(sorted(str))
            res_map[key].append(str)
        return list(res_map.values())


    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res_map = collections.defaultdict(list)
        for str in strs:
            count = [0] * 26
            for c in str:
                count[ord(c)-ord('a')] += 1
            res_map[tuple(count)].append(str)

        return list(res_map.values())

# @lc code=end

