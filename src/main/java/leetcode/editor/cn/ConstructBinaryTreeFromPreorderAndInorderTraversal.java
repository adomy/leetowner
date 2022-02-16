/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回
 * 其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 * <p>
 * Related Topics 树 数组 哈希表 分治 二叉树 👍 1418 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTreeInner(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        public TreeNode buildTreeInner(int[] preorder, int begin1, int end1, int[] inorder, int begin2, int end2) {
            TreeNode root = new TreeNode();
            root.val = preorder[begin1];
            if (begin1 == end1 || begin2 == end2) {
                return root;
            }

            for (int i = begin2; i <= end2; i++) {
                if (inorder[i] == root.val) {
                    if (i == begin2) {
                        root.left = null;
                        root.right = buildTreeInner(preorder, begin1 + 1, end1, inorder, i + 1, end2);
                    } else if (i == end2) {
                        root.left = buildTreeInner(preorder, begin1 + 1, end1, inorder, begin2, i - 1);
                        root.right = null;
                    } else {
                        root.left = buildTreeInner(preorder, begin1 + 1, end1, inorder, begin2, i - 1);
                        root.right = buildTreeInner(preorder, begin1 + (i - begin2 + 1), end1, inorder, i + 1, end2);
                    }
                }
            }

            return root;
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