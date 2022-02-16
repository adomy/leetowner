/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节
 * 点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * Related Topics 链表 👍 1154 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class ReverseLinkedListIi {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}