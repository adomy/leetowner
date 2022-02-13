/**
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目在范围 [0, 1000]
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 * <p>
 * Related Topics 链表 👍 248 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class SplitLinkedListInParts {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts().new Solution();
        ListNode head = new ListNode(1);
        ListNode nodem = head;
        for (int i = 2; i <= 3; i++) {
            ListNode node = new ListNode(i);
            nodem.next = node;
            nodem = node;
        }

        solution.splitListToParts(head, 5);
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
        public ListNode[] splitListToParts(ListNode head, int k) {
            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }

            // x+y=k
            // ax+(a-1)k=len
            // a <= (len+k)/k
            // y = ak-len
            int aver = (len + k) / k; // 每组为aver个
            int y = aver * k - len; // 每组为aver-1个元素的组数
            int x = k - y; // 每组为aver个元素的组数

            node = head;
            int ic = 0;
            int gc = 0;
            ListNode newHead = node;
            ListNode[] nodes = new ListNode[k];
            nodes[gc] = newHead;
            ListNode prev = null;
            while (node != null) {
                if (gc < x) {
                    if (ic < aver) {
                        prev = node;
                        node = node.next;
                        ic++;
                    } else {
                        gc++;
                        nodes[gc] = node;
                        ic = 0;
                        if (prev != null) {
                            prev.next = null;
                        }
                    }
                } else {
                    if (ic < aver - 1) {
                        prev = node;
                        node = node.next;
                        ic++;
                    } else {
                        gc++;
                        nodes[gc] = node;
                        ic = 0;
                        if (prev != null) {
                            prev.next = null;
                        }
                    }
                }
            }

            return nodes;
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