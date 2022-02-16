/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如
 * 果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= temperatures.length <= 10⁵
 * 30 <= temperatures[i] <= 100
 * <p>
 * Related Topics 栈 数组 单调栈 👍 1014 👎 0
 */

package leetcode.editor.cn;

import java.util.Stack;

/**
 * leetcode test.
 */
public class DailyTemperatures {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < temperatures.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }

                int top = stack.peek();
                int target = temperatures[i];
                while (!stack.isEmpty() && temperatures[top] < target) {
                    res[top] = i - top;
                    stack.pop();

                    if (!stack.isEmpty()) {
                        top = stack.peek();
                    }
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                res[stack.pop()] = 0;
            }

            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}