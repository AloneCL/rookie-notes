package main.java.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenguanglei
 * @date 2024/2/4
 */
public class LongestConsecutive128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int consecutive = 1;
                int nowConsecutive = 1;
                while (set.contains(i + 1)) {
                    consecutive++;
                    i++;
                }
                max = Math.max(max, consecutive);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longested = longestConsecutive(nums);
        System.out.println(longested);
    }
}
