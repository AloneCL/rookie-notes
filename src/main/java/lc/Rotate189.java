package main.java.lc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenguanglei
 * @date 2024/2/5
 */
public class Rotate189 {
    public static int[] rotate(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> list2 = list.subList(list.size() - k, list.size());
        for (int i = 0; i < nums.length - k; i++) {
            list2.add(nums[i]);
        }
        return list2.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] ints = rotate(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}
