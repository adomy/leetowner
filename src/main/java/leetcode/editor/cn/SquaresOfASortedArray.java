/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 已按 非递减顺序 排序
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * <p>
 * Related Topics 数组 双指针 排序 👍 428 👎 0
 */

package leetcode.editor.cn;

import java.util.Arrays;

/**
 * leetcode test.
 */
public class SquaresOfASortedArray {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquaresV1(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i] * nums[i];
            }

            Arrays.sort(res);
            return res;
        }

        public int[] sortedSquares(int[] nums) {
            int len = nums.length;
            int[] res = new int[len];
            int pos = len - 1;

            int left = 0, right = len - 1;
            while (left <= right) {
                int leftSquare = nums[left] * nums[left];
                int rightSquare = nums[right] * nums[right];
                if (leftSquare <= rightSquare) {
                    res[pos--] = rightSquare;
                    right--;
                } else {
                    res[pos--] = leftSquare;
                    left++;
                }
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}