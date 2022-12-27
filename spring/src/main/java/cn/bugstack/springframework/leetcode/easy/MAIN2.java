package cn.bugstack.springframework.leetcode.easy;

import java.util.Stack;

/**
 * @Auther: 李清依
 * @Date: 2022/10/30 15:05
 * @Description:
 */
public class MAIN2 {
    /**
     * 1047. 删除字符串中的所有相邻重复项
     *
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (char c:chars
             ) {
            if (stack.isEmpty()){
                stack.push(c);
            }else {
                if (stack.peek().equals(c)){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        int res=stack.size();
        char arr[]=new char[stack.size()];
        while (!stack.isEmpty()){
            arr[res--]=stack.pop();
        }
        return new String(arr);
    }
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while (i<=j){
            int mid=i+(j-i)/2;
            if (nums[mid]>=target){
                j=mid;
            }
            if (nums[mid]<target){
                i=mid+1;
            }
        }
        int count=0;
        while (i<nums.length&&nums[i++]==target){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println((char) (1% 26 + 'A'));
    }

    public String convertToTitle(int columnNumber) {
        int n=columnNumber;
        StringBuilder sb=new StringBuilder();
        while (n>0){
            n--;
            sb.append((char)(n%26+'A'));
            n=n/26;
        }
        return sb.reverse().toString();
    }
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }

}
