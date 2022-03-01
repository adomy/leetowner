//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1339 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode
 * 题目标题: 和为 K 的子数组
 * 题目编号: 560
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        solution.subarraySum(new int[]{1, 1, 1}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 计算前缀和
            int[] prefixSumArray = new int[nums.length + 1];
            prefixSumArray[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                prefixSumArray[i + 1] = prefixSumArray[i] + nums[i];
            }

            // 从前往后，找减去k后存在的个数
            int count = 0;
            Map<Integer, Integer> valueCountMap = new HashMap<>();
            valueCountMap.put(0, 1);
            for (int i = 1; i <= nums.length; i++) {
                if (valueCountMap.containsKey(prefixSumArray[i] - k)) {
                    count = count + valueCountMap.get(prefixSumArray[i] - k);
                }

                valueCountMap.put(prefixSumArray[i], valueCountMap.getOrDefault(prefixSumArray[i], 0) + 1);
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}