/**
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 * <p>
 * <p>
 * 假设该列表是 answer = [a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|,
 * ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 * <p>
 * <p>
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3, k = 2
 * 输出：[1, 3, 2]
 * 解释：[1, 3, 2] 包含 3 个范围在 1-3 的不同整数，并且 [2, 1] 中有且仅有 2 个不同整数：1 和 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= k < n <= 10⁴
 * <p>
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 102 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class BeautifulArrangementIi {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new BeautifulArrangementIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] res = new int[n];
            res[0] = 1;

            for (int i = 1, interval = k; i <= k; i++, interval--) {
                if (i % 2 == 1) {
                    res[i] = res[i - 1] + interval;
                } else {
                    res[i] = res[i - 1] - interval;
                }
            }

            for (int i = k + 1; i < n; i++) {
                res[i] = i + 1;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}