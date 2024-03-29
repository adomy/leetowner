//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2176 👎 0


package leetcode.editor.cn;

/**
 * leetcode code
 * question name: 爬楼梯
 * question id: 70
 */
public class ClimbingStairs {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * f[1] = 1;
         * f[2] = 2;
         * f[n] = f[n-1] + f[n-2];
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }

            int a = 1;
            int b = 2;
            int tmp = 0;
            for (int i = 0; i + 2 < n; i++) {
                tmp = a + b;
                a = b;
                b = tmp;
            }

            return tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}