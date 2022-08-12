package main.java.lc.jzof;

/**
 * @author chenguanglei
 * @date 2022/8/12
 */
public class SingleNumbers56_Binary {

    /**
     * 异或运算有个重要的性质，两个相同数字异或为 00 ，即对于任意整数 aa 有 a⊕a=0
     * a⊕a⊕b⊕b⊕...⊕x
     * 0⊕0⊕...⊕x
     * x
     * ​
     *
     * @param nums
     * @return
     */

    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        // 1. 遍历异或
        for (int num : nums) {
            n ^= num;
        }
        // 2. 循环左移，计算 m
        while ((n & m) == 0) {
            m <<= 1;
        }
        // 3. 遍历 nums 分组
        for (int num : nums) {
            if ((num & m) != 0) {
                // 4. 当 num & m != 0
                x ^= num;
            } else {
                // 4. 当 num & m == 0
                y ^= num;
            }
        }
        // 5. 返回出现一次的数字
        return new int[]{x, y};
    }
}
