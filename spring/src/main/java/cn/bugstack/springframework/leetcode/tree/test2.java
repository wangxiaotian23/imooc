package cn.bugstack.springframework.leetcode.tree;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Auther: 李清依
 * @Date: 2022/10/8 08:45
 * @Description:
 */

public class test2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int m = 1;
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
            if (m % 2 == 0) {
                Collections.reverse(list);
            }
            m++;
            res.add(list);
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
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
                if (i == x - 1) {
                    res.add(poll.val);
                }
            }

        }
        return res;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public void invertTree1(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            } else {
                continue;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public int[] sortArrayByParityII(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j]==0){
                arr[i]=nums[j];
                i+=2;
            }
        }
        int k=1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j]!=0){
                arr[k]=nums[j];
                k+=2;
            }
        }
        return arr;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==p||root==q||root==null){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null&&right!=null){
            return root;
        }else if (left==null){
            return right;
        }else if (right==null){
            return left;
        }
        return root;
    }
}

class NumArray {
    private int preSum[];

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1 - left];
    }
}