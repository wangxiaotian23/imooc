package cn.bugstack.springframework.huawei;

import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/25 16:48
 * @Description:
 */
public class Main46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            int m=scanner.nextInt();
            String substring = str.substring(0, m);
            System.out.println(substring);
        }
    }
}
