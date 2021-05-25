package 二叉树;

/**
 * @author lyq on 2021-05-21 下午10:29
 * @desc
 */
public class 对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return compare(left.left, right.right) && compare(left.right, right.left);
        }
    }

}
