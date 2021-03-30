//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 515 👎 0


package leetcode.editor.cn;

public class Candy {

    /**
     * main函数
     **/
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
        int candy = solution.candy(new int[]{1, 0, 2});
        System.out.println(candy);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {

            int[] candys = new int[ratings.length];
            for (int i = 0; i < ratings.length; i++) {
                candys[i] = 1;
            }

            // 从左往右遍历一遍，如果右边的孩子评分比左边孩子评分高，同时candy小于等于左边孩子，那么就把candy=candy[左]+1
            for (int i = 0; i < ratings.length - 1; i++) {
                if (ratings[i + 1] > ratings[i] && candys[i + 1] <= candys[i]) {
                    candys[i + 1] = candys[i] + 1;
                }
            }

            for (int j = ratings.length - 1; j > 0; j--) {
                if (ratings[j - 1] > ratings[j] && candys[j - 1] <= candys[j]) {
                    candys[j - 1] = candys[j] + 1;
                }
            }

            int sum = 0;
            for (int i = 0; i < ratings.length; i++) {
                sum = sum + candys[i];
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}