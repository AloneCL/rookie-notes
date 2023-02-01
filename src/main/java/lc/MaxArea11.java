package main.java.lc;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * <p>
 * 返回容器可以储存的最大水量。
 * * 输入：[1,8,6,2,5,4,8,3,7]
 * * 输出：49
 * * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author chenguanglei
 * @date 2023/1/30
 */
public class MaxArea11 {

    public static int maxArea(int[] height) {
        int res = 0;
        //  int temp = 0;
        //  for(int i = 0; i < height.length; i++){
        //      if(height[i] == 0){
        //          continue;
        //      }
        //      for(int j = i+1; j < height.length; j++){
        //           if(height[i] >= height[j]){
        //               temp = (j-i) * height[j];
        //           }else{
        //               temp = (j-i) * height[i];
        //           }
        //           if(temp > res){
        //             res = temp;
        //           }
        //      }

        //  }

        //双指针
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            res = height[i] > height[j] ? Math.max(res, (j - i) * height[j--]) : Math.max(res, (j - i) * height[i++]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(nums));
    }
}
