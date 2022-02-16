/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * Related Topics 树 广度优先搜索 二叉树 👍 1170 👎 0
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode test.
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> resultList = new ArrayList<>();

            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> levelOrder = new ArrayList<>();
                int levelCount = queue.size();
                for (int i = 0; i < levelCount; i++) {
                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }

                    levelOrder.add(node.val);
                }

                resultList.add(levelOrder);
            }

            return resultList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static class TreeNode {
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