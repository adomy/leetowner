//给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <=
//i < j < n 且 nums[i] < nums[j] 。 
//
// 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [7,1,5,4]
//输出：4
//解释：
//最大差值出现在 i = 1 且 j = 2 时，nums[j] - nums[i] = 5 - 1 = 4 。
//注意，尽管 i = 1 且 j = 0 时 ，nums[j] - nums[i] = 7 - 1 = 6 > 4 ，但 i > j 不满足题面要求，所以 6
// 不是有效的答案。
// 
//
// 示例 2： 
//
// 输入：nums = [9,4,3,2]
//输出：-1
//解释：
//不存在同时满足 i < j 和 nums[i] < nums[j] 这两个条件的 i, j 组合。
// 
//
// 示例 3： 
//
// 输入：nums = [1,5,2,10]
//输出：9
//解释：
//最大差值出现在 i = 0 且 j = 3 时，nums[j] - nums[i] = 10 - 1 = 9 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 2 <= n <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 👍 42 👎 0


package leetcode.editor.cn;

/**
 * leetcode
 * 题目标题: 增量元素之间的最大差值
 * 题目编号: 2016
 */
public class MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {
        Solution solution = new MaximumDifferenceBetweenIncreasingElements().new Solution();
        solution.maximumDifference(new int[]{999, 997, 980, 976, 948, 940, 938, 928, 924, 917, 907, 907, 881, 878, 864, 862, 859, 857, 848, 840, 824, 824, 824, 805, 802, 798, 788, 777, 775, 766, 755, 748, 735, 732, 727, 705, 700, 697, 693, 679, 676, 644, 634, 624, 599, 596, 588, 583, 562, 558, 553, 539, 537, 536, 509, 491, 485, 483, 454});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumDifference(int[] nums) {
            int maxDiff = -1; // 当前最大的差值
            int preMin = nums[0]; // 整数数组中，index坐标之前的最小值

            int index = 1; //
            while (index < nums.length) {
                if (nums[index] > preMin) {
                    maxDiff = Math.max(maxDiff, nums[index] - preMin);
                }

                preMin = Math.min(preMin, nums[index]);
                index++;
            }

            return maxDiff;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}