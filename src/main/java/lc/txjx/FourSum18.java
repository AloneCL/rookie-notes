package main.java.lc.txjx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2023/2/7
 */
public class FourSum18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> lists = threeSum(nums, target - nums[i], i);
            if (!lists.isEmpty()) {
                for (List<Integer> list : lists) {
                    List<Integer> newList = new ArrayList(list);
                    newList.add(nums[i]);
                    res.add(newList);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = start + 1; i < nums.length - 2; i++) {
            if (i > start + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
//            int t = target;
            while (l < r) {
                long t = target - nums[i] - nums[l] - nums[r];
                if (t > 0) {
                    while (l < r && nums[l] == nums[++l]) {
                    }
                } else if (t < 0) {
                    while (l < r && nums[r] == nums[--r]) {
                    }
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[++l]) {
                    }
                    while (l < r && nums[r] == nums[--r]) {
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        FourSum18 test = new FourSum18();
        System.out.println(test.fourSum(nums, 0));
    }
}
