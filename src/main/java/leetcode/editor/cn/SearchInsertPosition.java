/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * <p>
 * <p>
 * 示例 5:
 * <p>
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 为无重复元素的升序排列数组
 * -10⁴ <= target <= 10⁴
 * <p>
 * Related Topics 数组 二分查找 👍 1342 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class SearchInsertPosition {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        solution.searchInsert(new int[]{1, 3, 5, 6}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return target > nums[left] ? left + 1 : left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}