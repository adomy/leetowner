//给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。 
//
// 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 
//
// 请你计算并返回达到楼梯顶部的最低花费。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10,15,20]
//输出：15
//解释：你将从下标为 1 的台阶开始。
//- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
//总花费为 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1,100,1,1,1,100,1,1,100,1]
//输出：6
//解释：你将从下标为 0 的台阶开始。
//- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
//- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
//- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
//- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
//总花费为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
// Related Topics 数组 动态规划 👍 791 👎 0


package leetcode.editor.cn;

/**
 * leetcode code
 * question name: 使用最小花费爬楼梯
 * question id: 746
 */
public class MinCostClimbingStairs {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
        solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * sum[i] = min{sum[i-1] + cost[i-1], sum[i-2] + cost[i-2]}
         *
         * @param cost
         * @return
         */
        public int minCostClimbingStairs(int[] cost) {
            int[] sum = new int[cost.length + 2];
            sum[0] = 0;
            sum[1] = 0;
            sum[2] = 0;
            for (int i = 3; i <= cost.length + 1; i++) {
                sum[i] = Math.min(sum[i - 1] + cost[i - 2], sum[i - 2] + cost[i - 3]);
            }

            return sum[cost.length + 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}