package main.java.lc.jzof;

import main.java.lc.common.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenguanglei
 * @date 2022/8/12
 */
public class IsBalanced55_TreeDfs {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //判断左子树
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        //判断右子树
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }
        //绝对值>=2代表高度差被打破 直接返回-1 否则返回该树最大深度
        return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right) + 1;
    }
}
