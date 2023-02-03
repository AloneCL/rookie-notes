package main.java.lc.txjx;

import java.util.Arrays;

/**
 * @author chenguanglei
 * @date 2023/2/2
 */
public class ThreeSumClosest16 {


    /**
     * 最接近的三数之和
     *
     * @param nums
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];

                if (Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }

                if (temp > target) {
                    r--;
                } else if (temp < target) {
                    l++;
                } else {
                    return target;
                }


            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

}
