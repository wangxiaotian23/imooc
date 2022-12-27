package cn.bugstack.springframework.amoscloud;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/11/29 14:06
 * @Description:
 */
/*
  输入一串字符串
  字符串长度不超过100
  查找字符串中相同字符连续出现的最大次数

  输入描述
    输入只有一行，包含一个长度不超过100的字符串

  输出描述
    输出只有一行，输出相同字符串连续出现的最大次数

   说明：
     输出

   示例1：
     输入
       hello
     输出
       2

    示例2：
      输入
       word
      输出
       1

     示例3：
      输入
        aaabbc
       输出
        3

    字符串区分大小写
   */
public class main75 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int max = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            int len = 1;
            index = i;
            while (index+1<chars.length&&chars[index]==chars[index+1]) {
                index++;
                len++;
            }
            max=Math.max(len,max);
        }

        System.out.println(max);
    }
}
