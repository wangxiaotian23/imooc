package cn.bugstack.springframework.leetcode.tanxin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 李清依
 * @Date: 2022/10/3 19:02
 * @Description:
 */
public class test1 {

    /**
     * 3. 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int count=0;
        Map<Character,Integer> map=new HashMap<>();
        int i=0,len=s.length();
        int left=0,right=0;
        while (i<len){
            if (map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            right=i;
            i++;
            count=Math.max(count,right-left+1);
        }
        return count;
    }


    /**
     * 15. 三数之和
     * @param nums
     * @return
     */

//    public List<List<Integer>> threeSum(int[] nums) {
//
//    }



    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count += 1;
                i++;
            }
            j++;
        }

        return count;
    }
}
