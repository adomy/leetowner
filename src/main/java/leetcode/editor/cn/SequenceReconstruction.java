//请判断原始的序列 org 是否可以从序列集 seqs 中唯一地 重建 。
//
// 序列 org 是 1 到 n 整数的排列，其中 1 ≤ n ≤ 10⁴。重建 是指在序列集 seqs 中构建最短的公共超序列，即 seqs 中的任意序列都
//是该最短序列的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入: org = [1,2,3], seqs = [[1,2],[1,3]]
//输出: false
//解释：[1,2,3] 不是可以被重建的唯一的序列，因为 [1,3,2] 也是一个合法的序列。
// 
//
// 示例 2： 
//
// 
//输入: org = [1,2,3], seqs = [[1,2]]
//输出: false
//解释：可以重建的序列只有 [1,2]。
// 
//
// 示例 3： 
//
// 
//输入: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
//输出: true
//解释：序列 [1,2], [1,3] 和 [2,3] 可以被唯一地重建为原始的序列 [1,2,3]。
// 
//
// 示例 4： 
//
// 
//输入: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
//输出: true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// org 是数字 1 到 n 的一个排列 
// 1 <= segs[i].length <= 10⁵ 
// seqs[i][j] 是 32 位有符号整数 
// 
//
// 
//
// 注意：本题与主站 444 题相同：https://leetcode-cn.com/problems/sequence-reconstruction/ 
// Related Topics 图 拓扑排序 数组 👍 10 👎 0


package leetcode.editor.cn;

import java.util.List;

/**
 * leetcode
 * 题目标题: 重建序列
 * 题目编号: 剑指 Offer II 115
 */
public class SequenceReconstruction {
    public static void main(String[] args) {
        Solution solution = new SequenceReconstruction().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}