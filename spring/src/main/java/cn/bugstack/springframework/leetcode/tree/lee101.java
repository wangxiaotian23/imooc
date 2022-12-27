package cn.bugstack.springframework.leetcode.tree;

/**
 * @Auther: 李清依
 * @Date: 2022/11/6 23:06
 * @Description:
 */
public class lee101 {
    //只要不相等，或者有一个为空都判为false
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }

        return isduichen(root.left,root.right);
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
}
