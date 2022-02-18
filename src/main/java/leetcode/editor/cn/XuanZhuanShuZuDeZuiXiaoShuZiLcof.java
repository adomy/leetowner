//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 
//输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 522 👎 0


package leetcode.editor.cn;

/**
 * leetcode code
 * question name: 旋转数组的最小数字
 * question id: 剑指 Offer 11
 */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minArrayV2(int[] numbers) {
            int beg = 0;
            int end = numbers.length - 1;
            while (beg < end) {
                int mid = beg + (end - beg) / 2;
                if (numbers[mid] < numbers[end]) {
                    end = mid;
                } else if (numbers[mid] > numbers[end]) {
                    beg = mid + 1;
                } else {
                    end--;
                }
            }

            return numbers[beg];
        }

        public int minArray(int[] numbers) {
            return findMin(numbers, 0, numbers.length - 1);
        }

        private int findMin(int[] numbers, int beg, int end) {
            if (beg >= end) {
                return numbers[end];
            }

            int mid = beg + (end - beg) / 2;
            if (numbers[mid] > numbers[end]) {
                return findMin(numbers, mid + 1, end);
            } else if (numbers[mid] < numbers[end]) {
                return findMin(numbers, beg, mid);
            } else {
                return findMin(numbers, beg, end - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}