//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 203 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode
 * 题目标题: 扑克牌中的顺子
 * 题目编号: 剑指 Offer 61
 */
public class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        boolean straight = solution.isStraight(new int[]{0, 0, 1, 2, 5});
        System.out.println(straight);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            Set<Integer> numSet = new HashSet<>();

            int ghostNum = 0;
            int max = 0;
            int min = 14;
            for (int num : nums) {
                if (num == 0) {
                    ghostNum++;
                    continue;
                }

                numSet.add(num);
                max = Math.max(max, num);
                min = Math.min(min, num);
            }


            return numSet.size() + ghostNum == nums.length && max - min < nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}