//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 610 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * leetcode
 * 题目标题: 01 矩阵
 * 题目编号: 542
 */
public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Zero1Matrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 答案版本
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            boolean[][] visited = new boolean[m][n];

            // 把零捆在一起
            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            int[][] dist = new int[m][n];
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                // 上
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    dist[x - 1][y] = dist[x][y] + 1;
                    queue.offer(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
                // 下
                if (x + 1 < m && !visited[x + 1][y]) {
                    dist[x + 1][y] = dist[x][y] + 1;
                    queue.offer(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
                // 左
                if (y - 1 >= 0 && !visited[x][y - 1]) {
                    dist[x][y - 1] = dist[x][y] + 1;
                    queue.offer(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                // 右
                if (y + 1 < n && !visited[x][y + 1]) {
                    dist[x][y + 1] = dist[x][y] + 1;
                    queue.offer(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
            }

            return dist;
        }


        // 该方法时间和空间都会超
        public int[][] updateMatrixWrongVersion(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            int[][] ret = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        ret[i][j] = minZeroDist(mat, i, j);
                    }
                }
            }

            return ret;
        }

        private int minZeroDist(int[][] mat, int i, int j) {
            int m = mat.length;
            int n = mat[0].length;

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{i, j});

            int dist = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int index = 0; index < size; index++) {
                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];

                    if (mat[x][y] == 0) {
                        return dist;
                    }

                    // 上
                    if (x - 1 >= 0) {
                        queue.offer(new int[]{x - 1, y});
                    }
                    // 下
                    if (x + 1 < m) {
                        queue.offer(new int[]{x + 1, y});
                    }
                    // 左
                    if (y - 1 >= 0) {
                        queue.offer(new int[]{x, y - 1});
                    }
                    // 右
                    if (y + 1 < n) {
                        queue.offer(new int[]{x, y + 1});
                    }
                }
                dist++;
            }

            return dist;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}