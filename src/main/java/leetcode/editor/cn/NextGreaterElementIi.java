/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * Related Topics 栈 数组 单调栈 👍 558 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class NextGreaterElementIi {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}