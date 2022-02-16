/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * Related Topics 递归 链表 👍 2184 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class MergeTwoSortedLists {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list2 == null) {
                return list1;
            }

            if (list1 == null) {
                return list2;
            }

            ListNode dummyNode = new ListNode();
            ListNode node = dummyNode;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    node.next = list1;
                    list1 = list1.next;
                } else {
                    node.next = list2;
                    list2 = list2.next;
                }
                node = node.next;
            }

            if (list1 != null) {
                node.next = list1;
            }

            if (list2 != null) {
                node.next = list2;
            }

            return dummyNode.next;
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