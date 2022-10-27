package cn.bugstack.springframework.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: 李清依
 * @Date: 2022/10/25 16:34
 * @Description:
 */
public class Main34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            for (char c:
                 chars) {
                System.out.print(c);
            }
        }
    }
}
