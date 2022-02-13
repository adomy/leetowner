/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] 不是 0 就是 1.
 * <p>
 * Related Topics 数组 👍 294 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class MaxConsecutiveOnes {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    count++;

                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }

            max = Math.max(max, count);

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}