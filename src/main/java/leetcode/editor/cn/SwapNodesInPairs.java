/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * Related Topics 递归 链表 👍 1231 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class SwapNodesInPairs {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode head = new ListNode(1);
        ListNode nodem = head;
        for (int i = 2; i <= 5; i++) {
            ListNode node = new ListNode(i);
            nodem.next = node;
            nodem = node;
        }
        solution.swapPairs(head);
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
        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            ListNode newHead = head.next;

            ListNode prev = null;
            ListNode node1 = head;
            ListNode node2 = head.next;
            while (true) {
                if (prev != null) {
                    prev.next = node2;
                }

                ListNode node2next = node2.next;
                node1.next = node2.next;
                node2.next = node1;
                prev = node1;

                node1 = node2next;
                if (node1 == null) {
                    break;
                }
                node2 = node1.next;
                if (node2 == null) {
                    break;
                }
            }

            return newHead;
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