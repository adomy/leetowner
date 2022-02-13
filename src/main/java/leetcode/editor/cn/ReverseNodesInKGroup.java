/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：head = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 * <p>
 * Related Topics 递归 链表 👍 1462 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class ReverseNodesInKGroup {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        n5.next = n6;

        ListNode listNode = solution.reverseKGroup(n1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode newHead = head;
            boolean headSet = false;

            int len = 0;
            ListNode prevSubLast = null;
            ListNode currSubHead = head;
            ListNode newSubLast = null;
            ListNode newSubHead = null;
            ListNode index = head;
            while (index != null) {
                index = index.next;
                len++;

                // 找到K长的子链表
                if (len == k) {
                    len = 0;

                    // 翻转子链表
                    newSubLast = currSubHead;
                    newSubHead = reverse(currSubHead, k);
                    if (!headSet) {
                        newHead = newSubHead;
                        headSet = true;
                    }
                    if (prevSubLast != null) {
                        prevSubLast.next = newSubHead;
                    }
                    prevSubLast = newSubLast;
                    currSubHead = index;
                }
            }

            if (len < k ) {
                if (prevSubLast != null) {
                    prevSubLast.next = currSubHead;
                }
            }

            return newHead;
        }

        public ListNode reverse(ListNode subHead, int k) {
            ListNode prev = null;
            ListNode curr = subHead;

            int i = 0;
            while (i < k) {
                ListNode post = curr.next;
                curr.next = prev;

                prev = curr;
                curr = post;
                i++;
            }

            return prev;
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