package 二叉树;

/**
 * @author lyq on 2021-05-24 下午10:11
 * @desc
 */
public class 插入二叉搜索树 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            TreeNode pre = new TreeNode(-1);
            travel(root, pre, val);
        }
        return root;
    }

    private void travel(TreeNode cur, TreeNode pre, int val) {
        if (cur == null) {
            TreeNode node = new TreeNode(val);
            if (pre.val > val) {
                pre.left = node;
            } else {
                pre.right = node;
            }
        } else {
            if (cur.val > val) {
                travel(cur.left, cur, val);
            } else {
                travel(cur.right, cur, val);
            }
        }
    }

}
