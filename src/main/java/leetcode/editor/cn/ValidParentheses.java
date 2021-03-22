//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2260 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 括号匹配
 */
public class ValidParentheses {

    /**
     * main函数
     **/
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();

        boolean valid;

        valid = solution.isValid("{({[]})[()]}");
        System.out.println(valid);

        valid = solution.isValid("{({[]})[(){]}");
        System.out.println(valid);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            char[] charArray = s.toCharArray();
            Map<Character, Character> chPair = new HashMap<>();
            chPair.put('}', '{');
            chPair.put(']', '[');
            chPair.put(')', '(');

            Deque<Character> stack = new LinkedList<>();

            for (int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];

                if (chPair.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != chPair.get(ch)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            return stack.isEmpty();
        }

        public boolean isValid_Old(String s) {
            char[] charArray = s.toCharArray();
            Map<Character, Character> chPair = new HashMap<>();
            chPair.put('}', '{');
            chPair.put(']', '[');
            chPair.put(')', '(');

            Deque<Character> stack = new LinkedList<>();

            for (int i = 0; i < charArray.length; i++) {
                char ch = charArray[i];
                if (ch == '{' || ch == '(' || ch == '[') {
                    stack.push(ch);
                    continue;
                }

                Character peek = stack.peek();
                if (peek != null && peek == chPair.get(ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
