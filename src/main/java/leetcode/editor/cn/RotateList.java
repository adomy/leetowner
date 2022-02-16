/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10⁹
 * <p>
 * Related Topics 链表 双指针 👍 722 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class RotateList {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();

        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        solution.rotateRight(n1, 4);
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return head;
            }

            int len = 0;
            ListNode tail = null;
            ListNode node = head;
            while (node != null) {
                len++;
                tail = node;
                node = node.next;
            }

            int x = k % len;
            if (x == 0) {
                return head;
            }

            ListNode nowTail = head;
            ListNode nowHead = head;
            node = head;
            for (int i = 0; i < len - x; i++) {
                nowTail = node;
                node = node.next;
                nowHead = node;
            }

            tail.next = head;
            nowTail.next = null;

            return nowHead;
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