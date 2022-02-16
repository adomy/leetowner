/**
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[
 * r][c] 的和：
 * <p>
 * <p>
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, k <= 100
 * 1 <= mat[i][j] <= 100
 * <p>
 * Related Topics 数组 矩阵 前缀和 👍 126 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class MatrixBlockSum {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new MatrixBlockSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}