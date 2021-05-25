package 二叉树;

/**
 * @author lyq on 2021-05-23 下午9:28
 * @desc 假设树中没有重复元素
 */
public class 从中序与后序遍历构造二叉树 {

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode tree = buildTree(inorder, postorder);
    }

    /**
     * 隐含条件：
     *    1、后序遍历中的最后一个元素是根节点;
     *    2、中序变量根节点左右两边的元素分别为其左右子树的节点
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        if (len == 0) return null;
        int root = postorder[len - 1];
        TreeNode rootNode = new TreeNode(root);
        // 在中序遍历中查找根节点的位置
        int idx = -1;
        for (int i=0;i<len;i++) {
            if (inorder[i] == root) {
                idx = i;
                break;
            }
        }
        // 左子树的中序遍历
        int[] leftIn = new int[idx];
        System.arraycopy(inorder, 0, leftIn, 0, idx);
        // 左子树的后序遍历
        int[] leftPost = new int[idx];
        System.arraycopy(postorder, 0, leftPost, 0, idx);
        // 右子树的中序遍历
        int[] rightIn = new int[len-idx-1];
        System.arraycopy(inorder, idx+1, rightIn, 0, len-idx-1);
        // 右子树的后序遍历
        int[] rightPost = new int[len-idx-1];
        System.arraycopy(postorder, idx, rightPost, 0, len-idx-1);
        rootNode.left = buildTree(leftIn, leftPost);
        rootNode.right = buildTree(rightIn, rightPost);
        return rootNode;
    }

}
