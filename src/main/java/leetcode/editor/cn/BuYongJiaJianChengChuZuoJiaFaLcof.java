//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 👍 263 👎 0


package leetcode.editor.cn;

/**
 * leetcode
 * 题目标题: 不用加减乘除做加法
 * 题目编号: 剑指 Offer 65
 */
public class BuYongJiaJianChengChuZuoJiaFaLcof {
    public static void main(String[] args) {
        Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int num1, int num2) {
            int sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            while (carry != 0) {
                int a = sum;
                int b = carry;
                sum = a ^ b;
                carry = (a & b) << 1;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}