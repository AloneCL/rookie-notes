package main.java.lc.jzof;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2022/8/12
 */
public class ReverseWords58 {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        int i = j;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(" ");
        }
        return sb.toString().trim();
    }
}
