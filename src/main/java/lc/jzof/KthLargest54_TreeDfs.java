package main.java.lc.jzof;

import main.java.lc.common.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2022/8/12
 */
public class KthLargest54_TreeDfs {
    int target = 0;
    int res;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    //倒序中序遍历 中序遍历为从小到大
    public void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        dfs(node.right, k);
        if (target == k) {
            return;
        }
        if (++target == k) {
            res = node.val;
        }
        dfs(node.left, k);
    }

}
