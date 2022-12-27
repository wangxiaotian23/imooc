package cn.bugstack.springframework.leetcode.dynamic;

/**
 * @Auther: 李清依
 * @Date: 2022/11/7 09:18
 * @Description:
 */
public class lee746 {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }
}
