package main.java.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenguanglei
 * @date 2023/2/6
 */
public class Subsets {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums, int n) {
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums, 0, list);
        return res;
    }

    public void backtrack(int[] nums, int index, LinkedList<Integer> list) {
        res.add(new ArrayList<>(list));
        System.out.println(list);
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(subsets.subsets(nums, 0));
    }
}
