package main.java.lc.jzof;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2022/8/12
 */
public class MinNumber45_QuickSort {

    /**
     * 若拼接字符串 x + y > y + xx+y>y+x ，则 xx “大于” yy ；
     * 反之，若 x + y < y + xx+y<y+x ，则 xx “小于” yy ；将此逻辑替换排序规则 从小到大排序
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        quickSort(str, 0, str.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public void quickSort(String[] str, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        String v = str[start];
        while (true) {

            while ((str[j] + str[start]).compareTo(str[start] + str[j]) >= 0 && i < j) {
                j--;
            }
            while ((str[i] + str[start]).compareTo(str[start] + str[i]) <= 0 && i < j) {
                i++;
            }
            if (i >= j) {
                break;
            }
            String s = str[i];
            str[i] = str[j];
            str[j] = s;
        }
        str[start] = str[j];
        str[j] = v;
        quickSort(str, start, j - 1);
        quickSort(str, j + 1, end);
    }
}
