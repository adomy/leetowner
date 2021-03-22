//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5859 👎 0


package leetcode.editor.cn;

public class AddTwoNumbers {

    /**
     * main函数
     **/
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

        ListNode listNode1 = new AddTwoNumbers().new ListNode(2);
        {
            ListNode listNode11 = new AddTwoNumbers().new ListNode(4);
            listNode1.next = listNode11;
            ListNode listNode12 = new AddTwoNumbers().new ListNode(3);
            listNode11.next = listNode12;
        }

        ListNode listNode2 = new AddTwoNumbers().new ListNode(5);
        {
            ListNode listNode21 = new AddTwoNumbers().new ListNode(6);
            listNode2.next = listNode21;
            ListNode listNode22 = new AddTwoNumbers().new ListNode(4);
            listNode21.next = listNode22;
        }

        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);

        ListNode curr = listNode;
        while (curr != null) {
            System.out.print(curr.val + "-");
            curr = curr.next;
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

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = null;

            int carry = 0;
            ListNode prevNode = null;
            while (!(l1 == null && l2 == null)) {
                int l1Var = l1 == null ? 0 : l1.val;
                int l2Var = l2 == null ? 0 : l2.val;
                int sum = l1Var + l2Var + carry;
                carry = sum / 10;

                ListNode listNode = new ListNode(sum % 10);
                if (result == null) {
                    result = listNode;
                }

                if (prevNode == null) {
                    prevNode = listNode;
                } else {
                    prevNode.next = listNode;
                    prevNode = listNode;
                }

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }

            if (carry > 0) {
                ListNode listNode = new ListNode(carry);
                prevNode.next = listNode;
            }

            return result;
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