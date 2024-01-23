package main.java.lc.txjx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenguanglei
 * @date 2023/2/7
 */
public class GenerateParenthesis22Dfs {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String s, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > right) {
            return;
        }
        
        if (left > 0) {
            dfs(s + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs(s + ")", left, right - 1, res);
        }

    }

    public static void main(String[] args) {
        GenerateParenthesis22Dfs dfs = new GenerateParenthesis22Dfs();
        System.out.println(dfs.generateParenthesis(3));
    }
}
