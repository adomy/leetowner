/**
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
 * <p>
 * 请你返回乘积为正数的最长子数组长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * <p>
 * <p>
 * Related Topics 贪心 数组 动态规划 👍 116 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class MaximumLengthOfSubarrayWithPositiveProduct {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfSubarrayWithPositiveProduct().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxLen(int[] nums) {
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}