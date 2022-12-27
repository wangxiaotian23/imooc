package cn.bugstack.springframework.leetcode.tree;

import java.util.*;

/**
 * @Auther: 李清依
 * @Date: 2022/10/30 15:56
 * @Description:
 */
public class test3 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.reverse(list);
        return list.get(k - 1);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) inorder(root.left, list);
        list.add(root.val);
        if (root.right != null) inorder(root.right, list);
    }

    public String largestNumber(int[] nums) {
        int sum = 0, max = 0;
        String strs[] = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        if (strs[0].charAt(0) == '0') return "0";
        return String.join("", strs);

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int arr[] = new int[temperatures.length];
        Arrays.fill(arr, 0);
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    arr[i] = j - i;
                    break;
                }
            }
        }
        return arr;
    }

    //    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root==null){
//            return false;
//        }
//        if (root==null&&targetSum==0){
//            return true;
//        }
//        hasPathSum(root.left,root.val-targetSum);
//        hasPathSum(root.left,root.val-targetSum);
//
//    }
    int sum = 0;

    public int sumNumbers(TreeNode root) {

        dfs(0, root);


        return sum;
    }

    public void dfs(int val, TreeNode root) {

        if (root == null) {
            return;
        }
        int k = val * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += k;
        }
        dfs(val, root.left);
        dfs(val, root.right);
    }

    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }

        }
        return maj;
    }

    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder1(root, list);
        return list.get(k - 1);
    }

    public void inorder1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder1(root.left, list);
        list.add(root.val);
        inorder1(root.right, list);
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        preorder(root,list);
        for (int i = 1; i <list.size() ; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode cur = list.get(i);
            prev.right=cur;
            prev.left=null;
        }

    }

    public void preorder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }
}
