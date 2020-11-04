/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    /**
     * 1,遍历字符串数组
     * 2，为每个字符串排序
     * 3，以排序后的字符串为key，放入字典中，字典的value为存放字符串list
     * 4，map的value转换为list集合
     * 9ms    62%      90%     41.3MB
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
for(String str:strs){
    char[] c = str.toCharArray();
    Arrays.sort(c);
    String key = String.valueOf(c);
    if(!map.containsKey(key)) map.put(key,new LinkedList<>());
    map.get(key).add(str);
}
return new LinkedList(map.values());
    }

    /**
     * 整体思想与方法一差不多，就是再判断是不是异味词时，这里采用的是数组的形式
     * 字符串相加部分会比较慢
     * 27ms    13%   37%   41MB
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        int[] count = new int[26];
for(String str:strs){
    Arrays.fill(count,0);
    for(char c : str.toCharArray())count[c-'a']++;
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<26;i++){
        sb.append("#");
        sb.append(count[i]);
    }
    String key = sb.toString();
    if(!map.containsKey(key))map.put(key,new LinkedList<>());
    map.get(key).add(str);
    
}
return new LinkedList(map.values());
    }
}
// @lc code=end

