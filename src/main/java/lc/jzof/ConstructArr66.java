package main.java.lc.jzof;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2023/1/17
 */
public class ConstructArr66 {

    public int[] constructArr(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return a;
        }
        int temp = 1;
        int[] res = new int[a.length];
        res[0] = 1;
        //构建左边区域 左三角
        for (int i = 1; i <= a.length - 1; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        //构建右边区域 右三角并相乘
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            res[i] *= temp;
        }

        return res;
    }
}
