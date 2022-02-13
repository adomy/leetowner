/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 279 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class ReshapeTheMatrix {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new ReshapeTheMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if (mat == null) {
                return null;
            }

            int m = mat.length;
            int n = mat[0].length;
            if (m * n != r * c) {
                return mat;
            }

            int[][] res = new int[r][c];
            for (int i = 0; i < r; i++) {
                res[i] = new int[c];
                for (int j = 0; j < c; j++) {
                    res[i][j] = 0;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int num = i * n + j;
                    int ni = num / c;
                    int nj = num % c;
                    res[ni][nj] = mat[i][j];
                }
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}