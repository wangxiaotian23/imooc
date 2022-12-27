package cn.bugstack.springframework.contest.ma12_11;

import java.util.*;

/**
 * @Auther: 李清依
 * @Date: 2022/12/14 11:19
 * @Description:
 */
public class main1 {
    public int deleteGreatestValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int max=0,res=0;
        for (int j = 0; j <grid[0].length ; j++) {
            for (int i = 0; i <grid.length ; i++) {
                max=Math.max(max,grid[i][j]);
            }
            res+=max;
        }
        return res;
    }


}
