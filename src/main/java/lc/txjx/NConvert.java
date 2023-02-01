package main.java.lc.txjx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenguanglei
 * @date 2023/1/29
 */
public class NConvert {

    public static String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList();
        //到达底部或顶部就更换标识 +1或-1
        int flag = -1;
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int t = 0;
        for (int l = 0; l < s.length(); l++) {
            list.get(t).append(s.charAt(l));
            if (t == 0 || t == numRows - 1) {
                flag = -flag;
            }
            t += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
