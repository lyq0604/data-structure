package 二叉树;

/**
 * @author lyq on 2021-05-24 下午10:53
 * @desc 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 */
public class 把二叉搜索树转换为累加树 {

    private static int pre = 0;

    /**
     * 1、反中序遍历：右->中->左;
     * 2、使用pre记录累加值
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        travel(root.right);
        root.val += pre;
        return root;
    }

    private void travel(TreeNode node) {
        if (node == null) return;
        // 遍历右子树，累加pre
        travel(node.right);
        node.val += pre;
        pre = node.val;
        // 处理左子树
        travel(node.left);
    }

}
