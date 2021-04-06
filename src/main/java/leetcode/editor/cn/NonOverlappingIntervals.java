//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法 
// 👍 392 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 在选择要保留的区间时，区间的结尾十分重要
 * -->> 选择的区间结尾越小，余留给其他区间的空间就越大，就越能保留更多的区间。
 * 贪心策略：优先保留结尾小且不相交的区间。
 * <p>
 * 尾排序 -->> 依次选择
 */
public class NonOverlappingIntervals {

    /**
     * main函数
     **/
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
        int[][] ints = {{1, 2}, {2, 3}};
        int i = solution.eraseOverlapIntervals(ints);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {

            Arrays.sort(intervals, (a, b) -> {
                if (a[1] < b[1]) {
                    return -1;
                } else if (a[1] == b[1]) {
                    return 0;
                } else {
                    return 1;
                }
            });

            int skipCnt = 0;
            int[] prev = null;
            for (int i = 0; i < intervals.length; i++) {
                int[] curr = intervals[i];
                if (prev == null) {
                    prev = curr;
                } else {
                    if (curr[0] >= prev[1]) {
                        prev = curr;
                    } else {
                        skipCnt++;
                    }
                }
            }

            return skipCnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}