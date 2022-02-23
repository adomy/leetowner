//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 500 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * leetcode
 * 题目标题: 腐烂的橘子
 * 题目编号: 994
 */
public class RottingOranges {

    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            boolean[][] visited = new boolean[m][n];
            int[][] dist = new int[m][n];

            // 把零捆在一起
            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        dist[i][j] = 0;
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }


            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                for (int d = 0; d < 4; d++) {
                    int ni = x + dirs[d][0];
                    int nj = y + dirs[d][1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj] && grid[ni][nj] == 1) {
                        dist[ni][nj] = dist[x][y] + 1;
                        visited[ni][nj] = true;
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        return -1;
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, dist[i][j]);
                }
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}