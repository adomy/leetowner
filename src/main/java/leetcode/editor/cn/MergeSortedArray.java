//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 906 👎 0


package leetcode.editor.cn;

public class MergeSortedArray {

    /**
     * main函数
     **/
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            // 三指针
            // 1. nums1 尾部--放数的地方
            // 2. nums2 游标
            // 3. nums1 游标
            int midx = m - 1;
            int nidx = n - 1;

            int ridx = m + n - 1;
            while (midx >= 0 && nidx >= 0) {
                if (nums1[midx] >= nums2[nidx]) {
                    nums1[ridx--] = nums1[midx--];
                } else {
                    nums1[ridx--] = nums2[nidx--];
                }
            }

            while (midx >= 0) {
                nums1[ridx--] = nums1[midx--];
            }

            while (nidx >= 0) {
                nums1[ridx--] = nums2[nidx--];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}