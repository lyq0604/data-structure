package 二叉树;

/**
 * @author lyq on 2021-05-23 下午11:02
 * @desc 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点等于其中任一节点，返回不为空
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // 左子树中的查询结果
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 右子树中的查询结果
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // p、q分别位于左、右子树中的情况
        if (left != null && right != null) {
            return root;
        // p、q均位于左子树中的情况
        } else if (left != null) {
            return left;
        // p、q均位于右子树中的情况
        } else {
            return right;
        }

    }

}
