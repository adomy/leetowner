/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * <p>
 * <p>
 * 示例2：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * <p>
 * <p>
 * 示例3：
 * <p>
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：如果输入链表不能翻转该如何解决？
 * Related Topics 栈 链表 数学 👍 480 👎 0
 */

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode test.
 */
public class AddTwoNumbersIi {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> num1 = new LinkedList<>();
            Deque<Integer> num2 = new LinkedList<>();
            while (l1 != null) {
                num1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                num2.push(l2.val);
                l2 = l2.next;
            }

            Deque<Integer> res = new LinkedList<>();
            int carry = 0;
            while (!num1.isEmpty() || !num2.isEmpty()) {
                int n1 = 0;
                if (!num1.isEmpty()) {
                    n1 = num1.pop();
                }
                int n2 = 0;
                if (!num2.isEmpty()) {
                    n2 = num2.pop();
                }
                res.push((n1 + n2 + carry) % 10);
                carry = (n1 + n2 + carry) / 10;
            }

            if (carry != 0) {
                res.push(carry);
            }

            ListNode dummyHead = new ListNode();
            ListNode prev = dummyHead;
            while (!res.isEmpty()) {
                ListNode node = new ListNode(res.pop());
                prev.next = node;
                prev = node;
            }

            return dummyHead.next;
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