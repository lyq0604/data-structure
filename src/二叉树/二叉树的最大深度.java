package 二叉树;

/**
 * @author lyq on 2021-05-21 下午10:37
 * @desc
 */
public class 二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        return getDepth(root) + 1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right));
    }

}
