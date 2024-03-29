//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 375 👎 0


package leetcode.editor.cn;

/**
 * leetcode
 * 题目标题: 最小的k个数
 * 题目编号: 剑指 Offer 40
 */
public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] res = new int[k];
            buildHeap(arr);

            int heapSize = arr.length;
            for (int i = 0; i < k; i++) {
                res[i] = arr[0];

                int tmp = arr[0];
                arr[0] = arr[heapSize - 1];
                arr[heapSize - 1] = tmp;

                heapSize--;
                maxHeapify(arr, 0, heapSize);
            }

            return res;
        }

        public void buildHeap(int[] arr) {
            for (int i = arr.length / 2; i >= 0; i--) {
                maxHeapify(arr, i, arr.length);
            }
        }

        public void maxHeapify(int[] arr, int index, int heapSize) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;

            if (left < heapSize && arr[smallest] > arr[left]) {
                smallest = left;
            }

            if (right < heapSize && arr[smallest] > arr[right]) {
                smallest = right;
            }

            if (smallest != index) {
                int tmp = arr[index];
                arr[index] = arr[smallest];
                arr[smallest] = tmp;

                maxHeapify(arr, smallest, heapSize);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}