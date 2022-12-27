package cn.bugstack.springframework.leetcode.easy;

/**
 * @Auther: 李清依
 * @Date: 2022/11/3 15:19
 * @Description:
 */
public class test1 {
    public int minSubArrayLen(int target, int[] nums) {
        int len=0,sum=0,left=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            while (sum>=target){
                if (len==0){
                    len=i-left+1;
                }else {
                    len=Math.min(len,i-left+1);
                }
                sum-=nums[left++];
            }
        }
        return len;
    }
    public int maxProfit(int[] prices) {
        int sum=0;
        int len=prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i]>prices[i-1]){
                sum+=prices[i]-prices[i-1];
            }
        }

        return sum;
    }
    public boolean isAnagram(String s, String t) {
        char arr[]=new char[s.length()];
        for (int i = 0; i <s.length() ; i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i <t.length() ; i++) {
            arr[s.charAt(i)-'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
