package 二叉树;

/**
 * @author lyq on 2021-05-24 下午10:19
 * @desc 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 */
public class 删除二叉搜索树中的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        // 找到要删除的节点
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                // 寻找右子树中的后继节点
                int nextVal = this.searchNext(root.right);
                // 将当前节点的值赋值为后继节点的值
                root.val = nextVal;
                // 从右子树中删除后继节点
                deleteNode(root.right, nextVal);
            }
        }
        return root;
    }

    private int searchNext(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

}
