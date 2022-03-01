//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 751 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode
 * 题目标题: 二进制求和
 * 题目编号: 67
 */
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println(0 + '0');
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {

            Deque<Character> retStack = new ArrayDeque<>();

            int aLen = a.length();
            int bLen = b.length();

            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();

            int carry = 0;
            int index = 1;
            while (index <= aLen && index <= bLen) {
                int aCh = aChars[aLen - index] - '0';
                int bCh = bChars[bLen - index] - '0';
                int sum = aCh + bCh + carry;

                int rChVal = sum % 2;
                carry = sum / 2;
                retStack.push((char) (rChVal + '0'));

                index++;
            }

            while (index <= aLen) {
                int aCh = aChars[aLen - index] - '0';
                int sum = aCh + carry;

                int rChVal = sum % 2;
                carry = sum / 2;
                retStack.push((char) (rChVal + '0'));

                index++;
            }

            while (index <= bLen) {
                int bCh = bChars[bLen - index] - '0';
                int sum = bCh + carry;

                int rChVal = sum % 2;
                carry = sum / 2;
                retStack.push((char) (rChVal + '0'));

                index++;
            }

            if (carry != 0) {
                retStack.push('1');
            }

            StringBuilder sb = new StringBuilder();
            while (!retStack.isEmpty()) {
                sb.append(retStack.pop());
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}