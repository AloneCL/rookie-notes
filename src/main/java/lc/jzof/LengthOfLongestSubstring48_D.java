package main.java.lc.jzof;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2022/8/12
 */
public class LengthOfLongestSubstring48_D {

    public int lengthOfLongestSubstring(String s) {
        //dp[j-1] 上一次结果
        //dp[j]结果为结尾字符s[j]的最大序列长度
        int res = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != s.charAt(i)) {
                j--;
            }
            temp = temp < i - j ? temp + 1 : i - j;
            res = Math.max(temp, res);
        }
        return res;
    }
}
