/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * <p>
 * Related Topics 递归 链表 👍 2263 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class ReverseLinkedList {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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

        // 0. nil->x->y->z
        //         |
        // 1. nil<-x->y->z
        //            |
        // 2. nil<-x-<y<-z
        public ListNode reverseList(ListNode head) {
            ListNode before = null;
            ListNode current = head;

            ListNode newHead = head;
            while (current != null) {
                ListNode after = current.next;
                if (after != null) {
                    newHead = after;
                }

                current.next = before;
                before = current;
                current = after;
            }

            return newHead;
        }

        public ListNode reverseListV2(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            ListNode newHead = head;
            while (curr != null) {
                ListNode post = curr.next;
                curr.next = prev;

                prev = curr;
                if (post != null) {
                    newHead = post;
                }
                curr = post;
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