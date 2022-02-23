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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        solution.reverseBetween(node1, 2, 4);
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null) {
                return null;
            }

            if (left == right) {
                return head;
            }

            ListNode before = null;
            ListNode current = head;

            int index = 1;

            // 先推进至left节点（left为子链表的头）
            while (index < left) {
                before = current;
                current = current.next;
                index++;
            }

            // 这里要做一个记录，记录两个信息， beforeLeftNode.next = newSubHeadNode;
            // 1. 以left为头部的链表的前一个节点
            ListNode beforeLeftNode = before;
            // 2. 记录子链表的头部信息，为left
            ListNode subHeadNode = current;

            // 继续往后面搜索处理，一直到right
            ListNode newSubHeadNode = current;
            while (index < right) {
                ListNode after = current.next; // 找到下一跳
                if (after != null) {
                    newSubHeadNode = after;
                }

                current.next = before; // 反转，current.next指向原来的前节点
                before = current; // 前节点后移
                current = after; // 当前节点后移
                index++;
            }

            subHeadNode.next = newSubHeadNode.next;
            newSubHeadNode.next = before;
            if (beforeLeftNode != null) {
                beforeLeftNode.next = newSubHeadNode;
                return head;
            } else {
                return newSubHeadNode;
            }
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