/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
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
 * Related Topics 树 广度优先搜索 二叉树 👍 533 👎 0
 */

package leetcode.editor.cn;

import java.util.*;

/**
 * leetcode test.
 */
public class BinaryTreeLevelOrderTraversalIi {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Deque<List<Integer>> stack = new ArrayDeque<>();

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                List<Integer> integers = new ArrayList<>();
                int levelCount = deque.size();
                for (int i = 0; i < levelCount; i++) {
                    TreeNode node = deque.poll();

                    if (node.left != null) {
                        deque.offer(node.left);
                    }

                    if (node.right != null) {
                        deque.offer(node.right);
                    }

                    integers.add(node.val);
                }
                stack.push(integers);
            }

            List<List<Integer>> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }

            return result;
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