//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1639 👎 0


package leetcode.editor.cn;

/**
 * leetcode code
 * question name: 跳跃游戏
 * question id: 55
 */
public class JumpGame {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        boolean b = solution.canJump(new int[]{2, 0, 0});
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * f[j] = f[i] && (j-i <= a[i])
         * <p>
         * 初始化：
         * f[0] = true;
         *
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            boolean[] res = new boolean[nums.length];
            res[0] = true;
            for (int j = 1; j < nums.length; j++) {
                res[j] = false;
                for (int i = 0; i < j; i++) {
                    if (!res[j]) {
                        res[j] = res[i] && (j - i <= nums[i]);
                    }
                }
            }

            return res[nums.length - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}