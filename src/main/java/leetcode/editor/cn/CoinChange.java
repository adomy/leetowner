/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2³¹ - 1
 * 0 <= amount <= 10⁴
 * <p>
 * Related Topics 广度优先搜索 数组 动态规划 👍 1714 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class CoinChange {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] tmp = new int[amount + 1];
            tmp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                tmp[i] = amount + 1;
            }

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0) {
                        tmp[i] = Math.min(tmp[i], tmp[i - coins[j]] + 1);
                    }
                }
            }

            return tmp[amount] > amount ? -1 : tmp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}