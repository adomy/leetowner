/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * Related Topics 数组 分治 动态规划 👍 4338 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class MaximumSubarray {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * f[i] = Math.max(f[i-1] + nums[i], nums[i]);
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int[] dp = new int[nums.length];

            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}