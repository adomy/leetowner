/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 5 * 10⁴
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 6871 👎 0
 */

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode test.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("pwwkew");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int maxBegin = 0;
            int maxEnd = 0;
            int maxLen = 0;
            boolean[] charArray = new boolean[1024];
            for (int begin = 0; begin < s.length(); begin++) {
                int end = begin;
                while (end < s.length()) {
                    char c = s.charAt(end);
                    if (charArray[c]) {
                        Arrays.fill(charArray, false);
                        break;
                    } else {
                        charArray[c] =true;
                        if (end - begin + 1 > maxLen) {
                            maxLen = end - begin + 1;
                            maxBegin = begin;
                            maxEnd = end;
                        }
                    }
                    end++;
                }
            }

            return maxLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}