package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/20 09:39
 * @Description:
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
        String next = in.next();
        String str = next.substring(2);
        int len = str.length() - 1;
        int res = 0;
        for (int i = 0; i <= len; i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                res += (c - '0') * (int) Math.pow(16, (len - i));
            }
            if (c >= 'A') {
                res += (c - 'A' + 10) * (int) Math.pow(16, (len - i));
            }
        }
        System.out.println(res);
//        }
    }
}
