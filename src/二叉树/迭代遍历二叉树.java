package 二叉树;

import java.util.*;

/**
 * @author lyq on 2021-05-20 下午11:03
 * @desc
 */
public class 迭代遍历二叉树 {

    public static List<TreeNode> list = new LinkedList<>();

    /**
     * 前序遍历
     * @param root
     */
    public static void preSearch(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                list.add(root);
                root = root.left;
            } else {
                TreeNode top = stack.peek();
                root = top.right;
                stack.pop();
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void midSearch(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode top = stack.pop();
                list.add(top);
                root = top.right;
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void afterSearch(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode top = stack.peek();
                // 防止死循环
                if (top.right != null && top.right != last) {
                    root = top.right;
                } else {
                    last = top;
                    stack.pop();
                    list.add(top);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        // preSearch(node1);
        // midSearch(node1);
        afterSearch(node1);
        list.forEach(item -> System.out.println(item.val));
    }

}
