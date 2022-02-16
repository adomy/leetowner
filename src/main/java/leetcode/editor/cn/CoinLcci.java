/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * <p>
 * <p>
 * 示例2:
 * <p>
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * <p>
 * <p>
 * 说明：
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * <p>
 * 0 <= n (总金额) <= 1000000
 * <p>
 * Related Topics 数组 数学 动态规划 👍 235 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class CoinLcci {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new CoinLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        static final int MOD = 1000000007;

        int[] coins = {25, 10, 5, 1};

        public int waysToChange(int n) {
            int[] f = new int[n + 1];
            f[0] = 1;
            for (int c = 0; c < 4; ++c) {
                int coin = coins[c];
                for (int i = coin; i <= n; ++i) {
                    f[i] = (f[i] + f[i - coin]) % MOD;
                }
            }
            return f[n];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}