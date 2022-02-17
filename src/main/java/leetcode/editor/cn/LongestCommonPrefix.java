/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * Related Topics 字符串 👍 2026 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class LongestCommonPrefix {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // LCP = LCP(LCP(LCP(1,2), 3),4....)
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            String prefix = strs[0];
            int count = strs.length;
            for (int i = 1; i < count; i++) {
                prefix = longestCommonPrefixInner(prefix, strs[i]);
                if (prefix.length() == 0) {
                    break;
                }
            }

            return prefix;
        }

        public String longestCommonPrefixInner(String str1, String str2) {
            int length = Math.min(str1.length(), str2.length());
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    stringBuilder.append(str1.charAt(i));
                } else {
                    break;
                }
            }

            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}