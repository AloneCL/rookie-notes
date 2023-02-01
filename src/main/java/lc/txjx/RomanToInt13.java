package main.java.lc.txjx;

/**
 * @author chenguanglei
 * @date 2023/2/1
 */
public class RomanToInt13 {

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i++;
                } else {
                    res += 1;
                }
            } else if (c == 'X') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i++;
                } else {
                    res += 10;
                }
            } else if (c == 'C') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'D') {
                    res += 400;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'M') {
                    res += 900;
                    i++;
                } else {
                    res += 100;
                }
            } else if (c == 'V') {
                res += 5;
            } else if (c == 'L') {
                res += 50;
            } else if (c == 'D') {
                res += 500;
            } else if (c == 'M') {
                res += 1000;
            }
        }


        return res;
    }
}
