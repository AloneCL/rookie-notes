package main.java.lc.jzof;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2022/12/30
 */
public class MaxProfits63_D {

    private int maxProfits(int[] prices) {
        int[] dp = new int[prices.length];
        int max = 0;
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
            if (dp[i] > max) {
                max = dp[i];
            }
            if (prices[i] < cost) {
                cost = prices[i];
            }
        }
        return max;
    }
}
