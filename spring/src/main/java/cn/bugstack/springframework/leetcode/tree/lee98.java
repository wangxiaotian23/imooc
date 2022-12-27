package cn.bugstack.springframework.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/11/8 20:01
 * @Description:
 */
public class lee98 {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
