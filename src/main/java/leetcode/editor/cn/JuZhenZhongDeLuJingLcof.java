//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 512 👎 0


package leetcode.editor.cn;

/**
 * leetcode
 * 题目标题: 矩阵中的路径
 * 题目编号: 剑指 Offer 12
 */
public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;

            char[] words = word.toCharArray();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, words, 0)) {
                        return true;
                    }
                }
            }

            return false;
        }

        /**
         * @param board
         * @param i
         * @param j
         * @param words words+k就是当前路径
         * @param k
         * @return
         */
        private boolean dfs(char[][] board, int i, int j, char[] words, int k) {
            if (i < 0 || i >= board.length) {
                return false;
            }
            if (j < 0 || j >= board[0].length) {
                return false;
            }
            if (board[i][j] != words[k]) {
                return false;
            }
            if (k == words.length - 1) {
                return true;
            }

            board[i][j] = '\0';
            boolean res = dfs(board, i + 1, j, words, k + 1) // 上
                    ||
                    dfs(board, i - 1, j, words, k + 1) // 下
                    ||
                    dfs(board, i, j - 1, words, k + 1) // 左
                    ||
                    dfs(board, i, j + 1, words, k + 1) // 右
                    ;
            board[i][j] = words[k];

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}