/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 按 严格递增 顺序排列
 * <p>
 * Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 934 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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

        /**
         * 中序遍历，左根右
         * <p>
         * 二叉搜索树，左小于根小于右 -- 因此，二叉搜索树的中序遍历为递增数组
         * <p>
         * 平衡的关键就是，左右差不多
         *
         * @param nums
         * @return
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            int len = nums.length;
            return sortArray2TreeInner(nums, 0, len - 1);
        }

        private TreeNode sortArray2TreeInner(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }

            int rootKey = (start + end) / 2;
            TreeNode root = new TreeNode();
            root.val = nums[rootKey];

            root.left = sortArray2TreeInner(nums, start, rootKey - 1);
            root.right = sortArray2TreeInner(nums, rootKey + 1, end);

            return root;
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