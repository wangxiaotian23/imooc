package cn.bugstack.springframework.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: 李清依
 * @Date: 2022/11/21 14:19
 * @Description:
 */
public class lee452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o->o[1]));
        int cnt=1,end=points[0][1];
        for (int i = 1; i <points.length ; i++) {
            if (points[i][0]<=end){
                continue;
            }
            cnt++;
            end=points[i][1];
        }
        return points.length-cnt;
    }
}
