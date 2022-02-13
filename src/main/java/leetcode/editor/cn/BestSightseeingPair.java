/**
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：values = [1,2]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= values.length <= 5 * 10⁴
 * 1 <= values[i] <= 1000
 * <p>
 * Related Topics 数组 动态规划 👍 275 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class BestSightseeingPair {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new BestSightseeingPair().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int ans = 0;
            int mx = values[0] + 0;
            for (int j = 1; j < values.length; j++) {
                ans = Math.max(ans, mx + values[j] - j);
                mx = Math.max(mx, values[j] + j);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}