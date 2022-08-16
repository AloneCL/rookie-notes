package main.java.lc.jzof;

import java.util.Arrays;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2022/8/16
 */
public class IsStraight61 {

    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                zero++;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                return false;
            }
            if (i > 0 && nums[i - 1] != 0 && nums[i] - 1 > nums[i - 1]) {
                zero -= nums[i] - nums[i - 1] - 1;
            }
        }
        return zero >= 0;

    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 5};
        System.out.println(isStraight(nums));
    }

}
