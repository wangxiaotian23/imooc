package cn.bugstack.springframework.leetcode.dynamic;

/**
 * @Auther: 李清依
 * @Date: 2022/11/7 11:39
 * @Description:
 */
public class lee343 {
    public int integerBreak(int n) {
        int dp[]=new int[n];
        dp[1]=1;
        dp[2]=1;
        return dp[n];
    }
}
