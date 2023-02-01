package main.java.lc;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2023/1/18
 */
public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            int j = 0;
            for (; j < res.length() && j < strs[i].length(); j++) {
                if (strs[i].charAt(j) != res.charAt(j)) {
                    break;
                }
            }
            res = strs[i].substring(0, j);
            if (res.equals("")) {
                return res;
            }
        }
        return res;
    }
}
