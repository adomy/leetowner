/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= k <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1474 👎 0
 */

package leetcode.editor.cn;

/**
 * leetcode test.
 */
public class KthLargestElementInAnArray {

    /**
     * main method
     */
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            // 建堆
            buildMaxHeap(nums, heapSize);
            // k大，则需要取k-1次
            for (int i = 0; i < k - 1; i++) {
                // 堆减小
                heapSize--;

                // 交换 0 和 预留出的最后一个值
                int curr = nums[0];
                nums[0] = nums[heapSize];
                nums[heapSize] = curr;

                // 建堆
                maxHeapify(nums, heapSize, 0);
            }

            return nums[0];
        }

        public void buildMaxHeap(int[] a, int heapSize) {
            // 第一个非叶子节点
            int nodeIndex = heapSize / 2;
            for (int i = nodeIndex; i >= 0; i--) {
                maxHeapify(a, heapSize, i);
            }
        }

        public void maxHeapify(int[] a, int heapSize, int index) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int largest = index;
            if (leftChild < heapSize && a[leftChild] > a[largest]) {
                largest = leftChild;
            }
            if (rightChild < heapSize && a[rightChild] > a[largest]) {
                largest = rightChild;
            }

            if (largest != index) {
                int temp = a[index];
                a[index] = a[largest];
                a[largest] = temp;

                maxHeapify(a, heapSize, largest);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}