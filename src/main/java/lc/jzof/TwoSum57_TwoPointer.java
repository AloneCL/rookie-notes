package main.java.lc.jzof;

/**
 * @author chenguanglei
 * @date 2022/8/12
 */
public class TwoSum57_TwoPointer {

    public int[] twoSum(int[] nums, int target) {
        int front = 0;
        int end = nums.length - 1;
        while (front < end) {
            int n = nums[front] + nums[end];
            if (n < target) {
                front++;
            } else if (n > target) {
                end--;
            } else {
                break;
            }
        }
        return new int[]{nums[front], nums[end]};
    }
}
