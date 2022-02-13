/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * <p>
 * Related Topics 数学 二分查找 👍 754 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class Sqrtx {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }

            if (x == 1) {
                return 1;
            }

            int left = 1;
            int right = x / 2;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (mid > x / mid) {
                    right = mid - 1;
                } else if (mid * mid == x) {
                    return mid;
                } else {
                    left = mid;
                }
            }

            return left;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}