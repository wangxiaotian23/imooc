package cn.bugstack.springframework;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/9/19 11:44
 * @Description:
 */
public class main {
    /**
     * 200. 岛屿数量
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


    /**
     * 15. 三数之和
     * @param nums
     * @return
     */
//    public List<List<Integer>> threeSum(int[] nums) {
//
//    }


    /**
     * 198. 打家劫舍
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums == null) {
            return 0;
        }
        int max = 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    /**
     * 53. 最大子数组和
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] < sum) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }

        return max;
    }

    /**
     * 69. x 的平方根
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int i = 1, j = x / 2;
        int mid = 0;
        while (i < j) {
            mid = (i + j) / 2;
            if (mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j;
    }

    /**
     * 344. 反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {

            char t = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = t;
        }
    }

    /**
     * 283. 移动零
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        int len = nums.length;
        for (int k = 0; k < len; k++) {
            if (nums[k] != 0) {
                nums[j++] = nums[k];
            }
        }
        while (j < len) {
            nums[j++] = 0;
        }
    }

    /**
     * 704. 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 191. 位1的个数
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & n - 1;
            count++;
        }

        return count;
    }

    /**
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSort(int nums[], int i, int j) {
        int left = i, right = j;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] < pivot) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }
        }
        nums[left] = pivot;
        quickSort(nums, i, left - 1);
        quickSort(nums, right + 1, j);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }
        int arr[][] = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = mat[index / n][index % n];
                index++;
            }
        }
        return arr;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0,max=0;
        int i=0;
        int left=0,right=0;
        while (i<nums.length){
            if (nums[left]==1){
                right++;
            }
            i++;
        }

        return count;

    }


    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        System.out.println(maxSubArray(nums));
    }

}
