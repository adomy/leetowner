//有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
//
// 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。 
//
// 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方
//向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。 
//
// 最后返回经过上色渲染后的图像。 
//
// 示例 1: 
//
// 
//输入: 
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//输出: [[2,2,2],[2,2,0],[2,0,1]]
//解析: 
//在图像的正中间，(坐标(sr,sc)=(1,1)),
//在路径上所有符合条件的像素点的颜色都被更改成2。
//注意，右下角的像素没有更改为2，
//因为它不是在上下左右四个方向上与初始点相连的像素点。
// 
//
// 注意: 
//
// 
// image 和 image[0] 的长度在范围 [1, 50] 内。 
// 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。 
// image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 276 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * leetcode
 * 题目标题: 图像渲染
 * 题目编号: 733
 */
public class FloodFill {
    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new FloodFill().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int currColor = image[sr][sc];
            if (currColor == newColor) {
                return image;
            }

            int rowCount = image.length;
            int colCount = image[0].length;

            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{sr, sc});
            image[sr][sc] = newColor;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int x = curr[0]; // 行
                int y = curr[1]; // 列
                // 上
                if (x - 1 >= 0 && image[x - 1][y] == currColor) {
                    image[x - 1][y] = newColor;
                    queue.offer(new int[]{x - 1, y});
                }
                // 下
                if (x + 1 < rowCount && image[x + 1][y] == currColor) {
                    image[x + 1][y] = newColor;
                    queue.offer(new int[]{x + 1, y});
                }
                // 左
                if (y - 1 >= 0 && image[x][y - 1] == currColor) {
                    image[x][y - 1] = newColor;
                    queue.offer(new int[]{x, y - 1});
                }
                // 右
                if (y + 1 < colCount && image[x][y + 1] == currColor) {
                    image[x][y + 1] = newColor;
                    queue.offer(new int[]{x, y + 1});
                }
            }

            return image;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}