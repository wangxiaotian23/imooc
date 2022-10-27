package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/26 19:09
 * @Description:
 */
public class Main37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int totalCount = getTotalCount(a);
            System.out.println(totalCount);
        }
    }
    public static int getTotalCount(int n){
        if (n==1||n==2){
            return 1;
        }else {
            return getTotalCount(n-1)+getTotalCount(n-2);
        }
    }
}
