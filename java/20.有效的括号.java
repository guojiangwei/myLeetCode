/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    /**1，用栈存放左括号
     * 2，用map存放合法的括号对，键存右括号，值存左括号
     * 3，扫描字符串，当扫描到左括号是入栈，扫描到右括号是判断栈顶是否是合肥的左括号
     * 3ms     26%    15%   37.1MB
     */
    public boolean isValid1(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character,Character> map = new HashMap<>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }
        };
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if(map.containsKey(tmp)){
                if(stack.isEmpty()||stack.peek()!=map.get(tmp)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(tmp);
            }
        }
        if(stack.isEmpty())return true;
        return false;

    }
    /**
     * 1，栈结构不变
     * 2，使用判断语句代替map
     * 此例判断语句写的很繁琐，不容易看懂
     * 2ms   78%   27%   37MB
     */
    public boolean isValid2(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if((tmp == '('||tmp == '['||tmp == '{')){
                stack.push(tmp);
                continue;
            }
            if(stack.isEmpty() && (tmp == ')'||tmp == ']'||tmp == '}') )
            return false;

            if((tmp == ')'&&stack.peek()=='(')||(tmp == '}'&&stack.peek()=='{')||(tmp == ']'&&stack.peek()=='[')){
                stack.pop();
            }else{
                return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    /**
     * 与算法二逻辑一样，只是if语句写的更精简，更易懂
     * 2ms 78%  30%    37MB
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);
            if(tmp == '(' )stack.push(')');
            else if(tmp == '[')stack.push(']');
            else if(tmp == '{')stack.push('}');
            else if(stack.isEmpty() || tmp != stack.pop() ) return false;
        }
        return stack.isEmpty();

    }
}
// @lc code=end

