/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * 0 <= k <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 数组 数学 双指针 👍 1317 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class RotateArray {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        solution.rotate(new int[]{1, 2}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate1(int[] nums, int k) {
            int len = nums.length;
            int[] res = new int[len];
            for (int i = 0; i < nums.length; i++) {
                res[(i + k) % len] = nums[i];
            }
            System.arraycopy(res, 0, nums, 0, len);
        }

        public void rotate(int[] nums, int k) {
            // 翻转数组
            reverse(nums, 0, nums.length - 1);
            // 翻转前k位
            reverse(nums, 0, k % nums.length - 1);
            // 翻转从K位到最后的几位
            reverse(nums, k % nums.length, nums.length - 1);
        }

        private void reverse(int[] nums, int s, int e) {
            while (s < e) {
                int tmp = nums[s];
                nums[s] = nums[e];
                nums[e] = tmp;

                s++;
                e--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}