/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * Related Topics 链表 双指针 👍 1786 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = new ListNode(1);
        ListNode nodem = head;
        for (int i = 2; i <= 5; i++) {
            ListNode node = new ListNode(i);
            nodem.next = node;
            nodem = node;
        }
        solution.removeNthFromEnd(head, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }

            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }

            int target = len - n + 1;
            if (target == 1) {
                return head.next;
            }

            ListNode nodex = head;
            ListNode prevx = head;
            int index = 1;
            while (nodex != null) {
                if (index == target) {
                    prevx.next = nodex.next;
                } else {
                    prevx = nodex;
                }

                nodex = nodex.next;
                index++;
            }

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
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