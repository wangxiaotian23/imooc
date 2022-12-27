package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/27 11:43
 * @Description:
 */
public class Main108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a*b/gcd(a,b));
        }
    }

    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a,int b){
        while (a%b!=0){
            int tmp=a;
            a=b;
            b=tmp%b;
        }
        return b;
    }
}
