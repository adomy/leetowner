/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: []
 * 输出: []
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 616 👎 0
 */

package leetcode.editor.cn;

import java.util.*;

/**
 * leetcode test.
 */
public class BinaryTreeRightSideView {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> integers = new ArrayList<>();
            if (root == null) {
                return integers;
            }

            Queue<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();

                    if (node.left != null) {
                        deque.offer(node.left);
                    }

                    if (node.right != null) {
                        deque.offer(node.right);
                    }

                    if (i == size - 1) {
                        integers.add(node.val);
                    }
                }
            }

            return integers;
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