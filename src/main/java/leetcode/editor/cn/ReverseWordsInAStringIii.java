//给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 示例 2: 
//
// 
//输入： s = "God Ding"
//输出："doG gniD"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s 包含可打印的 ASCII 字符。 
// s 不包含任何开头或结尾空格。 
// s 里 至少 有一个词。 
// s 中的所有单词都用一个空格隔开。 
// 
// Related Topics 双指针 字符串 👍 400 👎 0


package leetcode.editor.cn;

/**
 * leetcode code
 * question name: 反转字符串中的单词 III
 * question id: 557
 */
public class ReverseWordsInAStringIii {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        String s = solution.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();

            int i = 0;
            int start = -1;
            int end = -1;

            boolean inBlank = true;
            boolean inWord = false;
            while (i < s.length()) {
                if (inBlank && chars[i] != ' ') {
                    start = i;
                    inBlank = false;
                    inWord = true;
                }

                if (inWord && chars[i] == ' ') {
                    end = i;
                    reverseChars(chars, start, end);

                    inBlank = true;
                    inWord = false;
                }
                i++;
            }

            if (inWord) {
                end = s.length();
                reverseChars(chars, start, end);
            }

            return new String(chars);
        }

        public void reverseChars(char[] chars, int start, int end) {
            int left = start;
            int right = end - 1;
            while (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;

                left++;
                right--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}