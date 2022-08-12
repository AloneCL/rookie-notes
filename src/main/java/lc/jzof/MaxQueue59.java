package main.java.lc.jzof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2022/8/12
 */
public class MaxQueue59 {

    Deque<Integer> valueQue;
    Deque<Integer> maxQue;

    public MaxQueue59() {
        valueQue = new LinkedList<>();
        maxQue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQue.isEmpty()) {
            return -1;
        } else {
            return maxQue.peekFirst();
        }
    }

    //因为新增只能从尾部 所以最大值一定是后面才加入的
    public void push_back(int value) {
        while (!maxQue.isEmpty() && maxQue.peekLast() < value) {
            maxQue.removeLast();
        }
        maxQue.addLast(value);
        valueQue.addLast(value);
    }

    public int pop_front() {
        if (valueQue.isEmpty()) {
            return -1;
        }
        int val = valueQue.pollFirst();
        if (val == maxQue.peekFirst()) {
            maxQue.removeFirst();
        }
        return val;
    }
}
