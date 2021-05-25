package 二叉树;

/**
 * @author lyq on 2021-05-21 下午11:05
 * @desc
 */
public class 二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        return getDepth(root) + 1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth == 0 && rightDepth > 0) {
            return rightDepth + 1;
        } else if (leftDepth > 0 && rightDepth == 0) {
            return leftDepth + 1;
        } else {
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }

}
