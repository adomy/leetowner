/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目在范围 [1, 10⁴] 内
 * -10⁵ <= Node.val <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 411 👎 0
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode test.
 */
public class FindModeInBinarySearchTree {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
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
        public int[] findMode(TreeNode root) {
            if (root == null) {
                return null;
            }

            List<Integer> integers = new ArrayList<>();
            inorder(root, integers);

            Map<Integer, Integer> map = new HashMap<>();
            for (Integer integer : integers) {
                map.put(integer, map.getOrDefault(integer, 0) + 1);
            }

            int maxCount = -1;
            for (Integer integer : map.values()) {
                maxCount = Math.max(maxCount, integer);
            }

            int answerSize = 0;
            for (Integer integer : map.values()) {
                if (integer == maxCount) {
                    answerSize++;
                }
            }

            int[] res = new int[answerSize];
            int index = 0;
            for (Integer key : map.keySet()) {
                if (map.get(key) == maxCount) {
                    res[index++] = key;
                }
            }


            return res;
        }

        private void inorder(TreeNode root, List<Integer> ints) {
            if (root.left != null) {
                inorder(root.left, ints);
            }
            ints.add(root.val);
            if (root.right != null) {
                inorder(root.right, ints);
            }
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