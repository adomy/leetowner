//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 572 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode code
 * question name: 字符串的排列
 * question id: 567
 */
public class PermutationInString {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        boolean b = solution.checkInclusion("ab", "eidbaooo");
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            // 对子串进行处理
            int subLen = s1.length();
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (int i = 0; i < subLen; i++) {
                Character ch = s1.charAt(i);
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }

            int outerIndex = 0;
            while (outerIndex + subLen - 1 < s2.length()) {
                Map<Character, Integer> nowCharCountMap = new HashMap<>();
                // 对s2的子串进行处理
                boolean stopFlag = false;
                int moveSteps = 0;
                while (moveSteps < subLen) {
                    int innerIndex = outerIndex + moveSteps;
                    Character ch = s2.charAt(innerIndex);
                    // 如果s1串中不存在该字符，直接从该字符开始，往后搜
                    if (!charCountMap.containsKey(ch)) {
                        outerIndex = innerIndex;
                        stopFlag = true;
                        break;
                    }
                    // 如果s1串中存在该字符，就要做一些判断了
                    else {
                        // 统计一下该字符的出现次数
                        int chCnt = nowCharCountMap.getOrDefault(ch, 0) + 1;
                        // 如果出现次数大于s1中该字符的出现次数，说明这个就不适用了，外层的滑动窗口就后移一格
                        if (chCnt > charCountMap.get(ch)) {
                            stopFlag = true;
                            break;
                        }
                        // 如果不是，那么就把数据再做一次统计，继续后移
                        else {
                            nowCharCountMap.put(ch, chCnt);
                            moveSteps++;
                        }
                    }
                }

                if (!stopFlag) {
                    return true;
                }

                outerIndex++;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}