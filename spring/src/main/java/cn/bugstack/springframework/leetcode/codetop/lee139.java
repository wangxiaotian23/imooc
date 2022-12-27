package cn.bugstack.springframework.leetcode.codetop;

import java.util.List;

/**
 * @Auther: 李清依
 * @Date: 2022/11/9 08:46
 * @Description:
 */
public class lee139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        int dp[]=new int[len+1];
        dp[0]=1;
        for (int i = 1; i <=len ; i++) {
            for (int j = 0; j <i ; j++) {
                if (dp[j]==1&&wordDict.contains(s.substring(j,i))){
                    dp[i]=1;
                    break;
                }
            }
        }
        return dp[len]==1;
    }
}
