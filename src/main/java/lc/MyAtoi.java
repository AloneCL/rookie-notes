package main.java.lc;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2023/1/29
 */
public class MyAtoi {

    public static int myAtoi(String s) {
        int flag = 1;
        int res = 0;
        int index = 0;
        char[] chars = s.toCharArray();
        //使用指针移位来往后移位 最后循环处理数字
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) {
            return 0;
        }
        if (chars[index] == '+') {
            index++;
            flag = 1;
        } else if (chars[index] == '-') {
            index++;
            flag = -1;
        }
        while (index < s.length()) {
            if (chars[index] < '0' || chars[index] > '9') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (chars[index] - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10) {
                return Integer.MIN_VALUE;
            }
            int t = chars[index] - '0';
            res = 10 * res + t * flag;
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
