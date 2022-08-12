package main.java.lc.jzof;

import main.java.lc.common.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如下面的两个链表：
 * <p>
 * <p>
 * <p>
 * 在节点 c1 开始相交。
 *
 * @author chenguanglei
 * @date 2022/8/12
 */
public class GetIntersectionNode52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
