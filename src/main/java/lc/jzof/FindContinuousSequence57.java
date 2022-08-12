package main.java.lc.jzof;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2022/8/12
 */
public class FindContinuousSequence57 {

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList();
        while (i < j) {
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }
            //滑动 >=单独拉出来判断
            if (s < target) {
                j++;
                s += j;
            } else {
                s -= i;
                i++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
