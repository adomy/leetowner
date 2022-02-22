//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 439 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * leetcode
 * 题目标题: 机器人的运动范围
 * 题目编号: 剑指 Offer 13
 */
public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] visit = new boolean[m][n];
            visit[0][0] = true;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0, 0});

            int res = 0;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                res++;

                int x = poll[0];
                int y = poll[1];

                // 上
                extracted(visit, queue, x - 1, y, m, n, k);
                // 下
                extracted(visit, queue, x + 1, y, m, n, k);
                // 左
                extracted(visit, queue, x, y - 1, m, n, k);
                // 右
                extracted(visit, queue, x, y + 1, m, n, k);
            }

            return res;
        }

        private void extracted(boolean[][] visit, Queue<int[]> queue, int x, int y, int m, int n, int k) {
            if (x < 0 || x >= m) {
                return;
            }
            if (y < 0 || y >= n) {
                return;
            }

            int x_tens = x / 10;
            int x_ones = x % 10;
            int y_tens = y / 10;
            int y_ones = y % 10;
            int sum = x_tens + x_ones + y_tens + y_ones;

            if (!visit[x][y] && sum <= k) {
                queue.offer(new int[]{x, y});
                visit[x][y] = true;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}