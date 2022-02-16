/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目范围是 [2, 100]
 * 0 <= Node.val <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 相同
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 211 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class MinimumDistanceBetweenBstNodes {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int minDiffInBST(TreeNode root) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}