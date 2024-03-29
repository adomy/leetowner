//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 374 👎 0


package leetcode.editor.cn;

/**
 * leetcode
 * 题目标题: 把数字翻译成字符串
 * 题目编号: 剑指 Offer 46
 */
public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            if (num == 0) {
                return 1;
            }

            return dp(num);
        }

        private int dp(int num) {
            if (num < 10) {
                return 1;
            }

            if (num % 100 > 9 && num % 100 < 26) {
                return dp(num / 10) + dp(num / 100);
            } else {
                return dp(num / 10);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}