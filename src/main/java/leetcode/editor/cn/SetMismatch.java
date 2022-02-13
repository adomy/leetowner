/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个
 * 数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁴
 * 1 <= nums[i] <= 10⁴
 * <p>
 * Related Topics 位运算 数组 哈希表 排序 👍 250 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class SetMismatch {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
        solution.findErrorNums(new int[]{
                1, 2, 2, 4
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int len = nums.length;
            int[] array = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                array[i] = 0;
            }
            for (int i = 0; i < len; i++) {
                array[nums[i]]++;
            }
            int dup = -1, mis = -1;
            for (int i = 1; i <= len; i++) {
                if (array[i] == 2) {
                    dup = i;
                }

                if (array[i] == 0) {
                    mis = i;
                }
            }

            int[] res = new int[2];
            res[0] = dup;
            res[1] = mis;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}