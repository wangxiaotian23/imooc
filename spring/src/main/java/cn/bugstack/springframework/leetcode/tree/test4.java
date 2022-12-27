package cn.bugstack.springframework.leetcode.tree;

import java.util.*;

/**
 * @Auther: 李清依
 * @Date: 2022/11/1 20:52
 * @Description:
 */
public class test4 {
    public static void main(String[] args) {
        List<String> list = null;
//        List<String> newList = Optional.ofNullable(list).orElse(new ArrayList());
        list.forEach(x -> System.out.println(x));
    }
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                flag = true;
                continue;
            }
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
        }

        return flag;
    }

    int min = 0;

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public void path(int i, int j, int[][] grid, int sum) {
        if (i == grid.length && j == grid[0].length) {
            return;
        }
        sum += grid[i][j];
        min = Math.max(min, sum);
        path(i + 1, j, grid, sum);
        path(i, j + 1, grid, sum);
    }

    //    public int maxProfit(int[] prices) {
//
//    }
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }

        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if (root.left==null&&root.right==null){
            return 0;
        }
        int leftlen=0,rightlen=0;
        if (root.left!=null){
             leftlen= dfs(root.left)+1;
        }
        if (root.right!=null){
            rightlen=dfs(root.right)+1;
        }
        max=Math.max(max,leftlen+rightlen);
        return Math.max(leftlen,rightlen);
    }
}
