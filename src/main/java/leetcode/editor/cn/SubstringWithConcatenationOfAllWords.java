//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 602 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode code
 * question name: 串联所有单词的子串
 * question id: 30
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        List<Integer> integers = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        System.out.println(integers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> integers = new ArrayList<>();

            // 0. word个数及长度计算
            int wordCnt = words.length;
            int wordLen = words[0].length();

            // 1. words统计
            Map<String, Integer> wordCntMap = new HashMap<>();
            for (String word : words) {
                wordCntMap.put(word, wordCntMap.getOrDefault(word, 0) + 1);
            }

            // 2. 滑动窗口遍历，从i开始，窗口长度为wordCnt*wordLen
            for (int i = 0; i + wordCnt * wordLen < s.length() + 1; i++) {
                Map<String, Integer> subStrWordCntMap = new HashMap<>();

                // 3. 比较子串内的单词与words中的单词个数是否匹配
                int wordIndex = 0;
                while (wordIndex < wordCnt) {
                    String word = s.substring(i + wordIndex * wordLen, i + (wordIndex + 1) * wordLen);
                    if (wordCntMap.containsKey(word)) {
                        int subStrOneWordCnt = subStrWordCntMap.getOrDefault(word, 0) + 1;
                        subStrWordCntMap.put(word, subStrOneWordCnt);
                        if (subStrOneWordCnt > wordCntMap.get(word)) {
                            break;
                        }
                    } else {
                        break;
                    }

                    wordIndex++;
                }

                if (wordIndex == wordCnt) {
                    integers.add(i);
                }
            }

            return integers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}