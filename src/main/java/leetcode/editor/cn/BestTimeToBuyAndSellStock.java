/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 *
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁴
 * <p>
 * Related Topics 数组 动态规划 👍 2102 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            int len = prices.length;
            for (int i = 0; i < len; i++) {
                min = Math.min(prices[i], min);
                max = Math.max(prices[i] - min, max);
            }

            return max;
        }

        public int maxProfitV1(int[] prices) {
            int max = 0;
            int len = prices.length;
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    max = Math.max(prices[j] - prices[i], max);
                }
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}