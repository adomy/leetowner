/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * Related Topics 链表 👍 726 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode node = head.next;
            ListNode prev = head;
            while (node != null) {
                if (node.val == prev.val) {
                    prev.next = node.next;
                } else {
                    prev = node;
                }

                node = node.next;
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