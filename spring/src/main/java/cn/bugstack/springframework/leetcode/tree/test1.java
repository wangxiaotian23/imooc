package cn.bugstack.springframework.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: 李清依
 * @Date: 2022/10/4 13:16
 * @Description:
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class test1 {

    /**
     * 104. Maximum Depth of Binary Tree (Easy)
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }
    }

    /**
     * 101. 对称二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isduichen(root.left, root.right);
    }

    public boolean isduichen(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isduichen(left.left, right.right) && isduichen(left.right, right.left);
    }

    /**
     * 129. 求根节点到叶节点数字之和
     *
     * @param root
     * @return
     */
//    List<List<Integer>> res = new ArrayList<>();
//    public int sumNumbers(TreeNode root) {
//        int count=0;
//
//    }
//
//    public void path(TreeNode root,List<Integer> list) {
//        if (root == null) {
//            list.add(0);
//            res.add(list);
//            return;
//        }
//        list.add(root.val);
//        path(root.left,list);
//        path(root.right,list);
//    }

    /**
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int x = queue.size();
            for (int i = 0; i < x; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    list.add(poll.val);
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 662. 二叉树最大宽度
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int x = queue.size();
            max = Math.max(x, max);
            for (int i = 0; i < x; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    list.add(poll.val);
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
            res.add(list);
        }
        return max;
    }



}
