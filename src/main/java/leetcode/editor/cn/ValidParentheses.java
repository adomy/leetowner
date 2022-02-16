/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * Related Topics 栈 字符串 👍 2955 👎 0
 */

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * leetcode test.
 */
public class ValidParentheses {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> mapping = new HashMap<>();
            mapping.put('}', '{');
            mapping.put(')', '(');
            mapping.put(']', '[');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (mapping.values().contains(c)) {
                    stack.push(c);
                }
                if (mapping.keySet().contains(c)) {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    Character pop = stack.pop();
                    if (pop != mapping.get(c)) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}