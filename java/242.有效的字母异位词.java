/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    /**
     * 1,字符串转字符数组
     * 2，数组排序
     * 3，对比排序数组
     * 4ms    64%   61%    38.9MB
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        for(int i =0;i<s1.length;i++){
            if(s1[i]!=t1[i]) return false;
        }
        return true;
    }
/**
 * 1，创建一个26长度的数组result，
 * 2，s和t数组中的字符减去'a' 得出下标
 * 3，数据对应s的下标加1，
 * 4，数组对应t产生的下标减1
 * 5，遍历数组result，如果result中都是0 返回true 否则返回false
 * 5ms    49%    54%  38.9MB
 */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] result = new int[26];
        for(int i=0;i<s.length();i++){
            result[s.charAt(i) - 'a']++;
            result[t.charAt(i) - 'a']--;
        }
        for(int i=0;i<26;i++){
            if(result[i]!=0) return false;
        }
        return true;
    }
}
// @lc code=end

