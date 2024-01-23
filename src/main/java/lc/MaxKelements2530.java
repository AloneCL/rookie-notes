package main.java.lc;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * <p>
 * 在一步 操作 中：
 * <p>
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * <p>
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,10,10,10,10], k = 5
 * 输出：50
 * 解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,3,3,3], k = 3
 * 输出：17
 * 解释：可以执行下述操作：
 * 第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
 * 第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
 * 第 3 步操作：选中 i = 2 ，nums 变为 [1,2,1,3,3] 。分数增加 3 。
 * 最后分数是 10 + 4 + 3 = 17 。
 *
 * @author chenguanglei
 * @date 2024/1/23
 */
public class MaxKelements2530 {

    /**
     * 本地维持一个大顶堆  第一个元素修改后直接下沉
     *
     * @param nums
     * @param k
     * @return
     */
    public long maxKelements(int[] nums, int k) {
        heapify(nums);
        long res = 0;
        int top;
        for (int i = 0; i < k; i++) {
            top = nums[0];
            res += top;
            nums[0] = (int) Math.ceil(top / 3.0);
            heapify(nums);
        }
        return res;
    }

    private void heapify(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            sink(nums, i);
        }
    }

    private void sink(int[] nums, int i) {
        int l = nums.length;
        int left = i * 2 + 1;
        while (left < l) {
            int right = left + 1;
            int largest = right < l && nums[right] > nums[left] ? right : left;

            if (nums[i] > nums[largest]) {
                break;
            }
            swap(nums, i, largest);
            i = largest;
            left = 2 * i + 1;
        }
    }

    private void swap(int[] heap, int index, int parent) {
        int t = heap[index];
        heap[index] = heap[parent];
        heap[parent] = t;
    }


    public static void main(String[] args) {
        MaxKelements2530 maxKelements2530 = new MaxKelements2530();
        int[] nums = {245623986, 825265439, 662379008, 36757440, 54175861, 499499885, 550777192, 370626497, 908769625};
        System.out.println(maxKelements2530.maxKelements(nums, 7));
    }
}
