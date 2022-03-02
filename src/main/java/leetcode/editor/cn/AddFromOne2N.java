//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// Related Topics 位运算 递归 脑筋急转弯 👍 440 👎 0


package leetcode.editor.cn;

/**
 * leetcode
 * 题目标题: 求1+2+…+n
 * 题目编号: 剑指 Offer 64
 */
public class AddFromOne2N {
    public static void main(String[] args) {
        Solution solution = new AddFromOne2N().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumNums(int n) {
            return n == 0 ? 0 : n + sumNums(n - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}