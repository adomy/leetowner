//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3392 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubstring {

    /**
     * main函数
     **/
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String babad = solution.longestPalindrome("aacabdkacaa");
        System.out.println(babad);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * d 表示i/j之间的距离
         * 然后从i开始，d从0到len，进行处置
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            int len = s.length();
            char[] chars = s.toCharArray();
            boolean[][] f = new boolean[len][len];
            String ans = "";

            // i表示字符串开始位置
            // j表示字符串结束位置
            // d表示i,j之间的距离
            for (int d = 0; d < len; d++) {
                for (int i = 0; i + d < len; i++) {
                    int j = i + d;
                    if (d == 0) {
                        f[i][j] = true;
                    } else if (d == 1) {
                        f[i][j] = chars[i] == chars[j];
                    } else {
                        f[i][j] = f[i + 1][j - 1] && (chars[i] == chars[j]);
                    }

                    if (f[i][j] && (j - i + 1) > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}