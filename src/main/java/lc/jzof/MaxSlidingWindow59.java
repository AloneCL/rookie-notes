package main.java.lc.jzof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * @author chenguanglei
 * @date 2022/8/12
 */
public class MaxSlidingWindow59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList();
        for (int j = 0, i = 1 - k; j < nums.length; j++, i++) {
            if (i > 0 && queue.peekFirst() == nums[i - 1]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.removeLast();
            }
            queue.addLast(nums[j]);
            if (i >= 0) {
                res[i] = queue.peekFirst();
            }
        }
        return res;
    }
}
