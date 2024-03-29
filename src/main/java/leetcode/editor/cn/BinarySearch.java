/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返
 * 回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * <p>
 * Related Topics 数组 二分查找 👍 630 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class BinarySearch {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int begin = 0;
            int end = nums.length - 1;

            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}