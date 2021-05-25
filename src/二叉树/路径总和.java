package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyq on 2021-05-22 下午10:42
 * @desc 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class 路径总和 {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> sub = new ArrayList<>();
        travel(root, sub, target, list);
        return list;
    }

    private void travel(TreeNode node, List<Integer> sub, int target, List<List<Integer>> list) {
        sub.add(node.val);
        // 到达叶子节点
        if (node.left == null && node.right == null) {
            if (target == node.val) {
                list.add(new ArrayList<>(sub));
            }
            return;
        }
        if (node.left != null) {
            travel(node.left, sub, target - node.val, list);
            sub.remove(sub.size()-1);
        }
        if (node.right != null) {
            travel(node.right, sub, target - node.val, list);
            sub.remove(sub.size()-1);
        }
    }



}
