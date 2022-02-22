//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 👍 369 👎 0


package leetcode.editor.cn;

/**
 * leetcode
 * 题目标题: 剪绳子
 * 题目编号: 剑指 Offer 14- I
 */
public class JianShengZiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int cuttingRope(int n) {
            //定义dp数组，dp[i]表示长度为i的绳子剪成m端后长度的最大乘积(m>1)
            int dp[] = new int[n + 1];
            //初始化
            dp[2] = 1;
            //目标：求出dp[n]
            //dp[2]已知，从dp[3]开始求，直到求出dp[n]
            for (int i = 3; i <= n; i++) {
                //首先对绳子剪长度为j的一段,其中取值范围为 2 <= j < i
                for (int j = 2; j < i; j++) {

                    //转移方程如下
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                    //Math.max(j*(i-j),j*dp[i-j]是由于减去第一段长度为j的绳子后，可以继续剪也可以不剪
                    //Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]))是当j不同时，求出最大的dp[i]
                }
            }
            //现在已经求出每个长度i对应的最大乘积，返回dp[n]
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}