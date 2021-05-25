package 二叉树;

/**
 * @author lyq on 2021-05-21 下午11:39
 * @desc
 */
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) > 0;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : Math.max(leftDepth, rightDepth) + 1;
    }

}
